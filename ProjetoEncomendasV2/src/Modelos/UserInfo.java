package Modelos;

public class UserInfo {
    private static UserInfo instance;
    private String nomeUsuario;
    private String CPFU;
    private int idUsuario;

    public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	private UserInfo() {
        // Inicialização do nome de usuário
        this.nomeUsuario = null;
        this.CPFU = null;
    }

    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public String getCPFU() {
		return CPFU;
	}

	public void setCPF(String CPFU) {
		CPFU = CPFU;
	}

	public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
