package final_project;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullname;
    private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
// если нет конструктора, то компилятор по умолчанию дает свой.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
