package utils;

public class DadosUsuario {
	
	private static DadosUsuario instance;
    private int id;
    private String login;
    private String senha;
    
	private DadosUsuario() {

    }

    public static synchronized DadosUsuario getInstance() {
        if (instance == null) {
            instance = new DadosUsuario();
        }
        return instance;
    }

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
