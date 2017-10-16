
package listadupla;


public class Pessoa {
    private int cod;
    private String nome;
    private Pessoa proximo;
    private Pessoa anterior;

    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getProximo() {
        return proximo;
    }

    public void setProximo(Pessoa proximo) {
        this.proximo = proximo;
    }

    public Pessoa getAnterior() {
        return anterior;
    }

    public void setAnterior(Pessoa anterior) {
        this.anterior = anterior;
    }
    

  
    
    
}
