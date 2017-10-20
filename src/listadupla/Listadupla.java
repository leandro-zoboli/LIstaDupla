package listadupla;

import java.util.Scanner;

public class Listadupla {

    static Pessoa inicio;
    static Pessoa fim;
    static Pessoa anterior;

    public static void insereInicio() {
        Pessoa p = new Pessoa();
        p.setNome(pedeString("informe o nome da pessoa", 1, 100));
        p.setCod(pedeInt("informe o código da pessoa", 1, 100));
        if (inicio == null) {
            inicio = p;
            fim = p;
            p.setAnterior(null);
            p.setProximo(fim);
            fim.setProximo(null);
            fim.setAnterior(inicio);
        } else {
            inicio.setAnterior(p);
            p.setProximo(inicio);
            p.setAnterior(null);
            inicio = p;
        }
    }

    public static void insereFinal() {
        if (inicio == null) {
            System.out.println("não existe lista");
        } else {
            Pessoa p = new Pessoa();
            p.setNome(pedeString("informe o nome da pessoa", 1, 100));
            p.setCod(pedeInt("informe o código da pessoa", 1, 100));
            p.setAnterior(fim);
            fim.setProximo(p);
            p.setProximo(null);
            fim = p;
        }
    }

    public static void verificaPessoa() {
        if (inicio == null) {
            System.out.println("não existe lista");
        } else {
            boolean existe = false;
            Pessoa atual = inicio;
            int codigo = pedeInt("informe o codigo da pessoa a ser pesquisada", 1, 100);
            while (atual != null) {
                if (atual.getCod() == codigo) {
                    existe = true;
                    break;
                }
                atual = atual.getProximo();
            }

            if (existe == true) {
                System.out.println("Pessoa encontrada na lista");
            } else {
                System.out.println("Pessoa NÃO encontrada na lista");
            }
        }
    }

    public static void removeEspecifico() {
        if (inicio == null) {
            System.out.println("não existe lista");
        } else {
            Pessoa atual = inicio;
            int codigo = pedeInt("informe o codigo da pessoa a ser removida", 1, 100);
            while (atual != null) {
                if (atual.getCod() == codigo) {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                } else {
                    atual = atual.getProximo();
                }
            }
        }
    }

    public static int pedeInt(String msg, int min, int max) {
        int ret = min - 1;
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.nextInt();
                if (ret < min || ret > max) {
                    System.out.println("Informe um valor de " + min + " a " + max);
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret < min || ret > max || erro);
        return ret;
    }

    public static String pedeString(String msg, int min, int max) {
        String ret = "";
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.next();
                if (ret.length() < min || ret.length() > max) {
                    System.out.println("Informe um nome de " + min + " a " + max + " caracteres");
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret.length() < min || ret.length() > max || erro);
        return ret;
    }

    public static void menu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("1- incluir uma pessoa no início na lista(pronto)");
        System.out.println("2- incluir uma pessoa no fim da lista(pronto)");
        System.out.println("3- Incluir pessoa na segunda posição da lista(pronto)");
        System.out.println("4- Verificar se alguma pessoa específica está na lista(pronto)");
        System.out.println("5- Remover uma pessoa específica da lista");
        System.out.println("6- Remover a primeira pessoa da lista(pronto)");
        System.out.println("7- Remover a última pessoa da lista");
        System.out.println("8- Mostrar a lista da primeira para a última pessoa(pronto)");
        System.out.println("9- Mostrar a lista da última para a primeira pessoa");

    }

    public static void main(String[] args) {
        int resp = 0;
        do {
            menu();
            resp = pedeInt("Informe a opção desejada", 1, 10);
            switch (resp) {
                case 1:
                    insereInicio();
                    break;
                case 2:
                    insereFinal();
                    break;
                case 3:
                    if (inicio == null) {
                        System.out.println("não existe lista");
                    } else {
                        Pessoa p = new Pessoa();
                        p.setNome(pedeString("informe o nome da pessoa", 1, 100));
                        p.setCod(pedeInt("informe o codigo da pessoa", 1, 100));
                        p.setAnterior(inicio);
                        p.setProximo(inicio.getProximo());
                        inicio.setProximo(p);
                    }
                    break;
                case 4:
                    verificaPessoa();
                    break;
                case 5:
                    removeEspecifico();
                    break;
                case 6:
                    if (inicio == null) {
                        System.out.println("não existe lista");
                    } else {
                        if (inicio.getProximo() == null) {
                            inicio = null;
                            fim = null;
                        } else {
                            inicio = inicio.getProximo();
                            inicio.setAnterior(null);
                        }
                    }
                    break;
                case 7:
                    if (inicio == null) {
                        System.out.println("não existe lista");
                    } else {
                        fim = fim.getAnterior();
                        fim.setProximo(null);
                    }
                    break;
                case 8:
                    if (inicio == null) {
                        System.out.println("não existe lista");
                    } else {
                        Pessoa atual = inicio;
                        while (atual != null) {
                            System.out.println(atual.getCod() + "- " + atual.getNome());
                            atual = atual.getProximo();
                        }
                    }

                    break;
                case 9:
                    if (inicio == null) {
                        System.out.println("não existe lista");
                    } else {
                        Pessoa atual = fim;
                        while (atual != null) {
                            System.out.println(atual.getCod() + "- " + atual.getNome());
                            atual = atual.getAnterior();
                        }
                    }
                    break;
            }
        } while (resp != 0);

    }

}
