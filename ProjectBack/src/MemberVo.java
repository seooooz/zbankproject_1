

public class MemberVo {
	private String id;
	private String password;
	static MemberVo user;
	
	// �ٸ� Ŭ���������� LoginP���� �Էµ� id ��� �� �� �ְ� static���� ����.
	static void userinit(MemberVo v){
		user =   v;
	}

	public MemberVo() {

	}

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

}
