package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;
    private No cauda;
    public ListaLigada() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        No atual = cabeca;
        while (atual != null){
            if (atual.getValor() == valor){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        No atual = cabeca;
        int indice = 0;
        while (atual != null){
            if (atual.getValor() == valor){
                return indice;
            }
            atual = atual.getProximo();
            indice ++;
        }
        return -1;

    }

    @Override
    public int minimo() {
        No m = this.cabeca;
        int min = m.getValor();
        while(m != null){
           min = Math.min(min, m.getValor());
           m = m.getProximo();
        }
        return min;
    }

    @Override
    public int maximo() {
        No m = this.cabeca;
        int max = m.getValor();
        while (m != null){
        max  = Math.max(max, m.getValor());
        m = m.getProximo();
       }
       return max;
    }

    @Override
    public int predecessor(int valor) {
        if (cabeca == null){
            return -1;
        }
        else{ 
            No atual = cabeca;
        if (atual.getProximo() != null && atual.getProximo().getValor() == valor){
            return atual.getValor();
        }
            return predecessor(atual.getProximo().getValor());
        }
    }

    @Override
    public int sucessor(int valor) {
        No atual = new No(valor);
        if (atual.getProximo() != null){
            return atual.getProximo().getValor();
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No posicao = new No(valor);
        if(buscaIndice == 0){
            posicao.setProximo(this.cabeca);
            this.cabeca = posicao;
        }
        No atual = this.cabeca;
        for (int i = 0; i <= buscaIndice - 1 && atual != null; i++){
            atual = atual.getProximo();
        }
        atual = posicao;
    }

    @Override
    public void insereInicio(int valor) {
        if (this.cabeca == null) {
            this.cabeca = new No(valor);}
        else {
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }
    }

    @Override
    public void insereFim(int valor) {
        No m = new No(valor);
        if (this.cabeca == null){
            this.cabeca = m;
        }
        else{
            No aux = this.cabeca;
            while(aux.getProximo()!= null){
                aux = aux.getProximo();
            }
            aux.setProximo(m);
        }
    }

    @Override
    public void remove(int valor) {
        while(cabeca != null && cabeca.getValor() == valor){
            cabeca = cabeca.getProximo();
        }
    }

    @Override
    public void removeIndice(int indice) {
        No aux = null;
        No atual = this.cabeca;
        if(indice == 0){
            this.cabeca = this.cabeca.getProximo();
            return;
        }
        int pointer = 0;
        while(atual != null && pointer < indice){
            aux = atual;
            atual = atual.getProximo();
            pointer++;
        }
        if(atual != null){
            aux.setProximo(atual.getProximo());
        }
    }

    @Override
    public void removeInicio() {
        if (cabeca != null) {
            No aux = cabeca.getProximo();
            cabeca = aux;
        }   
    }

    @Override
    public void removeFim() {
    No atual = cabeca;
        if(cabeca != null){
            if(cabeca.getProximo() == null){
                cabeca = null;
            }
            if(cabeca.getProximo().getProximo() == null){
                cabeca.setProximo(null);
            }
        while(atual.getProximo().getProximo() != null){
            atual = atual.getProximo();
        }
    
    atual.setProximo(null);
        }
    }
}