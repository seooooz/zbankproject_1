
public class TransVo {
	private String id;
	private String account;
	static UserVo user;
	
	// �ٸ� Ŭ���������� LoginP���� �Էµ� id ��� �� �� �ְ� static���� ����.
	static void userinit(UserVo v){
		user =   v;
	}

	public TransVo() {

	}

	
	public TransVo(String account) {
		this.account = account;
	}


	public String getId() {
		return id;
	}


}


