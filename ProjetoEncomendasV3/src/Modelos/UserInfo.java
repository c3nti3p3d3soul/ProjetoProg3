package Modelos;

public class UserInfo {
    private static UserInfo instance;
    private String nomeUsuario;
    private String CPFUser;
    private int idUsuario;

    public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UserInfo() {
        // Inicialização do nome de usuário
        this.nomeUsuario = null;
        this.CPFUser = null;
    }

    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public String getCPFUser() {
		return CPFUser;
	}

	public void setCPFUser(String CPFUser) {
		CPFUser = CPFUser;
	}

	public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
