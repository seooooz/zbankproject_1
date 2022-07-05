
public class TransVo {
	private String id;
	private String account;
	static UserVo user;
	
	// 다른 클래스에서도 LoginP에서 입력된 id 얻어 올 수 있게 static으로 저장.
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


