package br.edu.ifmt.cba.alphalab.entity;


import br.edu.ifmt.cba.alphalab.entity.exception.ClienteException;

//@Entity

public class ClienteEntity implements IEntity<ClienteException> {
	

	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public ClienteEntity() {	}
	
	public ClienteEntity(Long id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public ClienteException validar() {
		StringBuilder msg = new StringBuilder();
		if (nome==null || nome.trim().length()==0)
			msg.append("Nome é de preenchimento obrigatório!\n");
		if (nome!=null && (nome.trim().length()<5 || nome.trim().length()>60))
			msg.append("Nome deve possuir entre 5 e 60 caracteres!\n");
		if (email==null || email.trim().length()==0)
			msg.append("E-mail é de preenchimento obrigatório!\n");
		if (email!=null && email.indexOf('@')==-1)
			msg.append("E-mail inválido!\n");
		if (telefone!=null && telefone.trim().length()>0)
			if (!telefone.matches("[0-9]{10}"))
			msg.append("Telefone inválido!\n");		
		
		if (msg.length()>0 )
			return new ClienteException(msg.toString());
		else
			return null;
	}
	
}
