package Utils;

public class User {
		
	public int id;
	public String name;
	public int salary;
	
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.salary = (int)(Math.random() * 10000);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
