package duoyi;

public class Test {
    public static void main(String[] args) {
        Person A = new Person("甲", true, "A", true);
        Person B = new Person("乙", false, "A", true);
        Person C = new Person("丙", false, "B", true);
        Person D = new Person("丁", false, "B", false);
        Person E = new Person("戊", true, "A", false);
        Person F = new Person("己", true, "B", false);
        Person[] murderList = {A, B, C, D, E, F};
        Person[] deadList = {B, C, D, E, F};
        for (int i = 0; i < murderList.length; i++) {
            for (int j = 0; j < deadList.length; j++) {
                if (!murderList[i].mName.equals(deadList[j].mName) && check(murderList[i], deadList[j])) {
                    System.out.println("凶手是:"+ murderList[i].mName);
                    System.out.println("死者是:"+ deadList[i].mName);
                }
            }
        }
    }

    public static boolean check(Person murder, Person dead) {
        if (murder.mSex == dead.mSex && !murder.mBloodType.equals("B")) {
            return false;
        }
        if (murder.mSex != dead.mSex && !dead.mBloodType.equals("A")) {
            return false;
        }
        if (murder.mNameType == dead.mNameType && !murder.mSex) {
            return false;
        }
        if (murder.mNameType != dead.mNameType && !murder.mBloodType.equals("A")) {
            return false;
        }
        if (murder.mBloodType == dead.mBloodType && !dead.mSex) {
            return false;
        }
        if (murder.mBloodType != dead.mBloodType && dead.mSex) {
            return false;
        }
        return true;
    }
}

class Person {
    public String mName;
    public boolean mSex;
    public String mBloodType;
    public boolean mNameType;

    public Person(String name, boolean sex, String bloodType, boolean nameType) {
        mName = name;
        mSex = sex;
        mBloodType = bloodType;
        mNameType = nameType;
    }
}
