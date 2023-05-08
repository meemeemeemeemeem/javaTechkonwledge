package study;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class 密码字典生成 {
    // 密码最短长度
    int min = 8;
    // 密码最长长度
    int max = 14;
    // 常用密码组合
    String[] MOST_USE = new String[] { "11111111", "00000000", "11223344", "0123456789", "000000", "0123456789",
            "101010", "111111", "111222", "112233", "11223344", "121212", "12121212", "12344321456", "1234567",
            "12345678", "123456789", "1234567890", "1234gwer", "1qaz2wsx", "2222415926", "555555", "7758521", "7758258",
            "77777777", "8888888", "99999999", "99999999", "abcdefg", "admin", "love", "qwertyuiop", "1314", "7788",
            "8899", "123", "1234","88888888" };
    // 常用年份组合
    String[] YEAR = new String[] { "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992",
            "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "85","86","87",
            "88","89","90","91","92","93","94","95","96","97","98","99","00"};
    // 常用月份组合
    String[] MONTH = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "1", "2",
            "3", "4", "5", "6", "7", "8", "9" };
    // 常用日期组合
    String[] DAY = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "1",
            "2", "3", "4", "5", "6", "7", "8", "9" };

    // 常用首字母
    String[] FLETTER = new String[] { "a","b", "c", "d", "e","f", "g", "h","i" ,"j", "k", "l", "m", "n","o", "p", "q",
            "r","s", "t","u","v" ,"w", "x", "y", "z" };
    // 常用姓氏组合
    String[] LASTNAME = new String[] { "li", "ma", "wu", "xu", "hu", "yu", "he", "liu", "sun", "gao", "luo", "cai",
            "guo", "zhu", "wang", "zhao", "yang", "zhou", "song", "meng", "deng", "zhang", "huang", "liang", "qian",
            "zheng", "feng", "chen", "hu", "shen", "han", "kong" };
    // 常用名字拼音组合
    String[] FIRSTNAME = new String[] { "bo", "bi", "bai", "bei", "bao", "ban", "ben", "bin", "bang", "bing", "biao",
            "ci", "cai", "can", "cen", "cun", "ceng", "cong", "cao", "chi", "chu", "chui", "chan", "chen", "cheng",
            "chang", "chong", "chuan", "chuang", "chao", "che", "cha", "chai", "de", "di", "du", "dai", "dao", "dan",
            "deng", "ding", "dang", "dong", "fa", "fu", "fei", "fan", "fen", " fang", "feng", "fou", "gu", "gui", "gao",
            "gai", "gan", "gen", "guo", "gang", "geng", "guan", "guang", "hu", "hui", "hao", "han", "hen", "huo",
            "hang", "heng", "huan", "huang", "hun", "ji", "ju", "jiu", "jie", "jin", "jun", " jue", "jing", "ji", "jia",
            "jiao", "jian", "juan", "jiang", "kai", "kui", "kan", "ken", "kun", "kuo", "kang", "keng", "kong", "kuan",
            "kuang", "le", "li", "lai", "lu", "lei", "lie", "lan", "lin", "lun", "lang", "ling", "long", "liao", "lian",
            "luan", "mi", "mu", "mai", "man", "mei", "mao", "miu", "min", "mang", "meng", "ming", "miao", "mian", "na",
            "ni", "nu", "niu", "nan", "nuo", "neng", "ning", "nv", "pa", "pi", "pu", "pai", "pen", "pin", "pan", "pao",
            "peng", "ping", "pang", "pian", "qi", "qu", "qiu", "qing", "qin", "quan", "qian", "qiao", "que", "ri", "re",
            "ruo", "rou", "ran", "ren", "rui", "rang", "reng", "sa", "si", "se", "su", "sai", "sun", "suo", "song",
            "sang", "san", "suan", "shi", "shu", "shui", "shan", "shen", "sheng", "shang", "shuan", "shuang", "shao",
            "she", "sha", "shai", "ta", "te", "tan", "tei", "ti", "tu", "tang", "tai", "tao", "tuo", "teng", "ting",
            "tun", "tong", "tian", "tou", "wa", "wu", "wai", "wei", "wang", "wan", "xi", "xu", "xiu", "xian", "xu",
            "xie", "xun", "xin", "xing", "xiang", "xiong", "xia", "xuan", "xue", "ya", "yi", "yu", "yao", "you", "yan",
            "yun", "yue", "yin", "ying", " yuan", "yang", "yong", "zu", "zao", "zui", "ze", "zi", "zou", "zuo", "zeng",
            "zuan", "zong", "zun", "zan", "zai" };
    // 常用特殊符号
//    String[] MOST_SIN = new String[] { "!", "@", "#", "_", "~", "*", "$", ",", ".", "," };

    public void create(String[] temp) throws IOException {
        File f = new File("./dict.txt");
        FileOutputStream fop = new FileOutputStream(f, true);
        OutputStreamWriter writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
        for (String i : temp) {
            String str = i + '\n';
            if (str.length() < this.max && str.length() > this.min)
                writer.append(str);
        }
        writer.close();
        fop.close();
    };

    public void create(String[] temp, String[] temp1) throws IOException {
        File f = new File("./dict.txt");
        FileOutputStream fop = new FileOutputStream(f, true);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        for (String i : temp) {
            for (String j : temp1) {
                String str = i + j + '\n';
                if (str.length() < this.max && str.length() > this.min)
                    writer.append(str);
            }
        }
        writer.close();
        fop.close();
    };

    public void create(String[] temp, String[] temp1, String[] temp2) throws IOException {
        File f = new File("./dict.txt");
        FileOutputStream fop = new FileOutputStream(f, true);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        for (String x : temp) {

            for (String y : temp1) {

                for (String z : temp2) {

                    String str = x + y + z + '\n';
                    if (str.length() < this.max && str.length() > this.min)
                        writer.append(str);
                }
            }
        }
        writer.close();
        fop.close();
    };

    public void create(String[] temp, String[] temp1, String[] temp2, String[] temp3) throws IOException {
        File f = new File("./dict.txt");
        FileOutputStream fop = new FileOutputStream(f, true);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        for (String a : temp) {

            for (String b : temp1) {

                for (String c : temp2) {

                    for (String d : temp3) {
                        String str = a + b + c + d + '\n';
                        if (str.length() < this.max && str.length() > this.min)
                            writer.append(str);
                    }
                }
            }
        }
        writer.close();
        fop.close();
    };

    public void create(String[] temp, String[] temp1, String[] temp2, String[] temp3, String[] temp4)
            throws IOException {
        File f = new File("./dict.txt");
        FileOutputStream fop = new FileOutputStream(f, true);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        for (String a : temp) {

            for (String b : temp1) {

                for (String c : temp2) {

                    for (String d : temp3) {

                        for (String e : temp4) {

                            String str = a + b + c + d + e + '\n';
                            if (str.length() < this.max && str.length() > this.min)
                                writer.append(str);
                        }
                    }
                }
            }
        }
        writer.close();
        fop.close();
    };

    public void create(String[] temp, String[] temp1, String[] temp2, String[] temp3, String[] temp4, String[] temp5)
            throws IOException {
        File f = new File("./dict.txt");
        FileOutputStream fop = new FileOutputStream(f, true);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        for (String a : temp) {

            for (String b : temp1) {

                for (String c : temp2) {

                    for (String d : temp3) {

                        for (String e : temp4) {

                            for (String z : temp5) {

                                String str = a + b + c + d + e + z + '\n';
                                if (str.length() < this.max && str.length() > this.min)
                                    writer.append(str);

                            }
                        }
                    }
                }
            }
        }
        writer.close();
        fop.close();
    };

    public static void main(String[] args) throws IOException {
        密码字典生成 createdict = new 密码字典生成();
        System.out.println("正在生成：姓+年");
        createdict.create(createdict.LASTNAME, createdict.YEAR);
        System.out.println("正在生成：姓+常用数字");
        createdict.create(createdict.LASTNAME, createdict.MOST_USE);
        System.out.println("正在生成：姓+年+月+日");
        createdict.create(createdict.LASTNAME, createdict.YEAR, createdict.MONTH, createdict.DAY);
        System.out.println("正在生成：姓+月+日+常用符号");
        createdict.create(createdict.LASTNAME, createdict.MONTH, createdict.DAY, createdict.MOST_USE);
        System.out.println("正在生成：姓+名+年");
        createdict.create(createdict.LASTNAME, createdict.FIRSTNAME, createdict.YEAR);
        System.out.println("正在生成：姓+名+月+日");
        createdict.create(createdict.LASTNAME, createdict.FIRSTNAME, createdict.MONTH, createdict.DAY);
        System.out.println("正在生成：姓+名+年+月+日");
        createdict.create(createdict.LASTNAME, createdict.FIRSTNAME, createdict.YEAR, createdict.MONTH, createdict.DAY);
        System.out.println("正在生成：姓+名+名+年");
        createdict.create(createdict.LASTNAME, createdict.FIRSTNAME, createdict.FIRSTNAME, createdict.YEAR);
        System.out.println("正在生成：姓+名+名+月+日");
        createdict.create(createdict.LASTNAME, createdict.FIRSTNAME, createdict.FIRSTNAME, createdict.MONTH,
                createdict.DAY);
        System.out.println("正在生成：姓+名+名+年+月+日");
        createdict.create(createdict.LASTNAME, createdict.FIRSTNAME, createdict.FIRSTNAME, createdict.YEAR,
                createdict.MONTH, createdict.DAY);
        System.out.println("正在生成：2字首字母+常用数字");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.MOST_USE);
        System.out.println("正在生成：2字首字母+年");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.YEAR);
        System.out.println("正在生成：2字首字母+月+日");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.MONTH, createdict.DAY);
        System.out.println("正在生成：2字首字母+年+月+日");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.YEAR, createdict.MONTH, createdict.DAY);

        System.out.println("正在生成：3字首字母+常用数字");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.FLETTER, createdict.MOST_USE);
        System.out.println("正在生成：3字首字母+年");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.FLETTER, createdict.YEAR);

        System.out.println("正在生成：3字首字母+月+日");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.FLETTER, createdict.MONTH, createdict.DAY);

        System.out.println("正在生成：3字首字母+年+月+日");
        createdict.create(createdict.FLETTER, createdict.FLETTER, createdict.FLETTER, createdict.YEAR, createdict.MONTH,
                createdict.DAY);

    }
}
