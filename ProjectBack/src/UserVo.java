

public class UserVo {
	private String name;
	private String id;
	private String password;
	static UserVo user;
	
	// �ٸ� Ŭ���������� LoginP���� �Էµ� id ��� �� �� �ְ� static���� ����.
	static void userinit(UserVo v){
		user =   v;
	}

	public UserVo() {

	}

	
	public UserVo(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}


