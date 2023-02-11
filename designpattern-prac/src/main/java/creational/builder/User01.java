package creational.builder;

class User01 {
    private final String name;
    private String tel;
    private String job;

    // 필수 인자 생성자
    public User01(String name) {
        this(name, "전화번호 없음", "직업 없음");
    }

    // 선택 인자 생성자
    public User01(String name, String tel) {
        this(name, tel, "직업 없음");
    }

    // 모든 인자 생성자
    public User01(String name, String tel, String job) {
        this.name = name;
        this.tel = tel;
        this.job = job;
    }
}