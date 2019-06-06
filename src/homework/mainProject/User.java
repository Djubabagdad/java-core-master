package homework.mainProject;

import java.util.Objects;

public class User {
    
    private String login;
    private String password;

    public User() {
    }

    private User(Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static class Builder{

        private String login;
        private String password;

        public Builder(){

        }
        public Builder withLogin(String login){
            this.login = login;
            return this;
        }
        public Builder withPassword(String password){
            this.password = password;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
