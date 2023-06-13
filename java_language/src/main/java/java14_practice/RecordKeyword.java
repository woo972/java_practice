package java14_practice;

public record RecordKeyword(String name, int age) {
    public String concatNameAndAge(){
        return name + age;
    }
}

class UsingRecord {
    public void test(){
         RecordKeyword recordKeyword = new RecordKeyword("name1",1000);
         recordKeyword.name();
         recordKeyword.age();
         recordKeyword.concatNameAndAge();
         recordKeyword.toString(); // hashcode, tosring,
    }
}

