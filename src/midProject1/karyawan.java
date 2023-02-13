package midProject1;

public class karyawan {
    public String name;
    public  String gender;
    public  String position;
    public  String code;
    public  int salary;
	
	public karyawan(String code, String name, String gender, String position, int salary) {
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.code = code;
        this.salary = salary;
	}
	
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
