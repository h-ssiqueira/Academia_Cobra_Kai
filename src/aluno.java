// Alcides Gomes Beato Neto		19060987
// Henrique Sartori Siqueira	19240472
// Rafael Silva Barbon			19243633

public class aluno extends Info{
    private float mensalidade; // DEFINIR MENSALIDADE DO ALUNO AO CADASTRAR EM UMA AULA
	private boolean mes_pago, auxiliar;
    private int atraso_conta, forma_pagamento, faixa;

    //Construtores
	public aluno(String nome, String CPF, String email, String telefone, String codigo, int forma_pagamento, Data nascimento, String senha){
		super.nome = nome;
        super.CPF = CPF;
        super.email = email;
        super.telefone = telefone;
		this.atraso_conta = 0;
		super.codigo = codigo;
		this.forma_pagamento = forma_pagamento;
		this.mes_pago = true;
		this.mensalidade = 0;
		super.nascimento = nascimento;
		this.faixa = 0;
		this.auxiliar = false;
		super.senha = senha;
	}
	/*
    public aluno(String nome, String CPF, String telefone){
		this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
		this.atraso_conta = 0;
	}
	public aluno(String nome, String CPF, String email){
		this.nome = nome;
        this.CPF = CPF;
        this.email = email;
		this.atraso_conta = 0;
	}
*/
	// Setters and getters

	@Override
	public void set_nome(String nome){
		super.nome = nome;
	}

	@Override
	public void set_CPF(String CPF){
		super.CPF = CPF;
	}

	@Override
	public void set_email(String email){
		super.email = email;
	}

	@Override
    public void set_telefone(String telefone){
		super.telefone = telefone;
	}

	public float get_mensalidade(){
		return this.mensalidade;
	}

	public void set_mensalidade(float mensalidade){
		this.mensalidade = mensalidade;
	}

	@Override
	public void set_nascimento(Data data){
		super.nascimento = data;
	}

	@Override
	public void set_senha(String senhaAntiga, String senhaNova){
		if(senhaAntiga.equals(get_senha())){
			super.senha = senhaNova;
		}
	}

	public int get_atraso_conta(){
		return this.atraso_conta;
	}

	public void set_forma_pagamento(int forma_pagamento){
		this.forma_pagamento = forma_pagamento;
	}

	public int get_forma_pagamento(){
		return this.forma_pagamento;
	}

	public boolean get_mes_pago(){
		return this.mes_pago;
	}

	public void set_faixa(int faixa){
		this.faixa = faixa;
	}

	public int get_faixa(){
		return this.faixa;
	}

	public void set_auxiliar(boolean auxiliar){
		if(this.faixa >= 9 && auxiliar)
			this.auxiliar = auxiliar;
		else if(!auxiliar)
			this.auxiliar = auxiliar;
	}

	public boolean get_auxiliar(){
		return this.auxiliar;
	}

	// Método que atribui atraso da conta de um cliente
	public void atraso(int meses){
		this.atraso_conta += meses;
		this.mes_pago = false;
	}

	// Método que torna a situação financeira de um cliente como pago
	public void pago(){
		this.mes_pago = true;
		this.atraso_conta = 0;
	}


	// Método que exibe as informações de um cliente
	@Override
	public void exibe(){
		System.out.println();
		System.out.printf("Nome: %s\n", get_nome());
		System.out.printf("CPF: %s\n", get_CPF());
		System.out.printf("Data de nascimento: " + get_nascimento()+"\n");
		System.out.printf("Email: %s\n", get_email());
		System.out.printf("Telefone: %s\n", get_telefone());
		System.out.printf("Número codigo: %.08s\n", get_codigo());
		System.out.print("Faixa: ");
		switch(get_faixa()){
			case 0:
			System.out.println("Amarela");
				break;
			case 1:
			System.out.println("Dourada");
				break;
			case 2:
			System.out.println("Laranja");
				break;
			case 3:
			System.out.println("Jade");
				break;
			case 4:
			System.out.println("Verde");
				break;
			case 5:
			System.out.println("Roxa");
				break;
			case 6:
			System.out.println("Azul");
				break;
			case 7:
			System.out.println("Vermelha");
				break;
			case 8:
			System.out.println("Marrom Clara");
				break;
			case 9:
			System.out.println("Marrom");
				break;
			case 10:
			System.out.println("Preta");
				break;
		}
		System.out.printf("Auxiliar: %s\n", get_auxiliar() ? "sim" : "não");
		System.out.printf("Valor da mensalidade: %.2f\n", get_mensalidade());
		System.out.printf("Forma de Pagamento: %s\n", get_forma_pagamento() == 1 ? "boleto bancário" : "débito automático");
		System.out.printf("Mensalidade: ");
		if(get_mes_pago()){
			System.out.println("em dia");
		}
		else{
			System.out.printf("atrasado %d meses\n", get_atraso_conta());
		}
		System.out.println();
	}

	// Método que retorna nome e código de um cliente para escolha de consulta
	public String toString(){
		return String.format("%s - %s\t", get_nome(), get_codigo());
	}
}

