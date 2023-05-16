### 1.2. 添加约束

```java
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    //getters and setters ...
}

```

### 1.3. 校验约束

```java
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        Car car = new Car(null, "DD-AB-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void licensePlateTooShort() {
        Car car = new Car("Morris", "D", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void seatCountTooLow() {
        Car car = new Car("Morris", "DD-AB-123", 1);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("must be greater than or equal to 2", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void carIsValid() {
        Car car = new Car("Morris", "DD-AB-123", 2);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);

        assertEquals(0, constraintViolations.size());
    }
}
```
在setUp()方法中,我们通过ValidatorFactory得到了一个Validator的实例. Validator是线程安全的,并且可以重复使用, 所以我们把它保存成一个类变量. 现在我们可以在test方法中使用这个validator的实例来校验不同的car实例了.

validate()方法会返回一个set的ConstraintViolation的实例的集合, 我们可以通过遍历它来查看有哪些验证错误. 前面三个测试用例显示了一些预期的校验约束:

在manufacturerIsNull()中可以看到manufacturer违反了@NotNull约束

licensePlateTooShort()中的licensePlate违反了@Size约束

而seatCountTooLow()中则导致seatCount违反了@Min约束

如果一个对象没有校验出问题的话,那么validate() 会返回一个空的set对象.

注意,我们只使用了Bean Validation API中的package javax.validation中的类, 并没有直接调用参考实现中的任何类,所以, 没有任何问题如果切换到其他的实现.

### 2.1. 定义约束
可以在字段和方法上面定义约束  
`
@NotNull
private String manufacturer;
`
```
@NotNull
public String getManufacturer() {
return manufacturer;
}
```
一个约束也能够被放在类级别上. 当一个约束被标注在一个类上的时候,
这个类的实例对象被传递给ConstraintValidator.
当需要同时校验多个属性来验证一个对象或者一个属性在验证的时候需要另外的属性的信息的时候, 类级别的约束会很有用.
在例 2.3 “类级别约束”中, 我们给类Car添加了一个passengers的属性. 
并且我们还标注了一个PassengerCount约束在类级别上. 
稍后会看到我们是如何创建这个自定义的约束的(第 3 章 创建自己的约束规则). 
现在,我们可以知道,PassengerCount会保证这个车里乘客的数量不会超过它的座位数.

```java
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PassengerCount
public class Car {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;
    
    private List<Person> passengers;
    
    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    //getters and setters ...
}

```

### 2.1.4. 约束继承
如果要验证的对象继承于某个父类或者实现了某个接口,那么定义在父类或者接口中的约束会在验证这个对象的时候被自动加载,
如同这些约束定义在这个对象所在的类中一样. 让我们来看看下面的示例:
```java
package com.mycompany;

import javax.validation.constraints.NotNull;

public class RentalCar extends Car {

    private String rentalStation;
    
    public RentalCar(String manufacturer, String rentalStation) {
        super(manufacturer);
        this.rentalStation = rentalStation;
    }
    
    @NotNull
    public String getRentalStation() {
        return rentalStation;
    }

    public void setRentalStation(String rentalStation) {
        this.rentalStation = rentalStation;
    }
}
```
我们有了一个新的RentalCar类继承自前面我们已经见到的Car, 这个子类中增加了一个rentalStation属性.
如果校验一个RentalCar的实例对象, 那么不仅会验证属性rentalStation上的 @NotNull约束是否合法,
还会校验父类中的manufacturer属性.
如果类Car是一个接口类型的话也是一样的效果.
如果类RentalCar 重写了父类Car的getManufacturer()方法, 
那么定义在父类的这个方法上的约束和子类这个方法上定义的约束都会被校验.

### 2.1.5. 对象图
Bean Validation API不仅能够用来校验单个的实例对象,还能够用来校验完整的对象图.
要使用这个功能,只需要在一个有关联关系的字段或者属性上标注@Valid. 
这样,如果一个对象被校验,那么它的所有的标注了@Valid的关联对象都会被校验.

```java
package com.mycompany;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class Car {

    @NotNull
    @Valid
    private List<Person> passengers = new ArrayList<Person>();

    public Car(Person driver) {
        this.driver = driver;
    }

    //getters and setters ...
}

class Person {
    @NotNull
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
```
如果校验Car的实例对象的话,因为它的driver属性标注了@Valid, 那么关联的Person也会被校验. 所以,如果对象Person的name属性如果是null的话,那么校验会失败.

关联校验也适用于集合类型的字段, 也就是说,任何下列的类型:

- 数组

- 实现了java.lang.Iterable接口( 例如Collection, List 和 Set)

- 实现了java.util.Map接口

如果标注了@Valid, 那么当主对象被校验的时候,这些集合对象中的元素都会被校验.

