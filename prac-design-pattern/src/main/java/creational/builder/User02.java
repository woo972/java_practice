package creational.builder;

class User02 {
    private final String name;
    private final String tel;
    private final String job;

    private User02(Builder builder) {
        this.name = builder.name;
        this.tel = builder.tel;
        this.job = builder.job;
    }

    public static class Builder {

        private final String name;
        private String tel = "전화번호 없음";
        private String job = "직업 없음";

        public Builder(String name) {
            this.name = name;
        }

        public Builder tel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public User02 build() {
            return new User02(this);
        }
    }
}