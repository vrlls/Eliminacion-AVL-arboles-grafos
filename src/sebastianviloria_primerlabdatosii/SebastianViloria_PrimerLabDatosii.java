/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sebastianviloria_primerlabdatosii;

import java.util.Scanner;

/**
 *
 * @author ESTU-5K
 */
public class SebastianViloria_PrimerLabDatosii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo raiz = null;
        int elem, n, sw = 1,op;
        System.out.println("Digite el numero de elementos ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int dato = (int) (Math.random() * 100 + 1);
            System.out.print(dato + ", ");
            raiz = AVL.insertar(raiz, dato);
        }
        System.out.println("");
        System.out.println("Etste es el preorden: ");
        Arbol.Preorden(raiz);
        while (sw == 1) {
            System.out.println("digite el elemento que desea eleiminar ");
            elem = sc.nextInt();
            Eliminar(raiz, elem);
            Arbol.Preorden(raiz);
            System.out.println();
            System.out.print("Marque 1 para seguir eliminando, sino otro numero");
            System.out.println();
            op=sc.nextInt();
            if(op!=1){
            sw=0;
            }
        }

    }

    public static void Eliminar(Nodo raiz, int elem) {
        Nodo x = null, h = null;
        if (BPadre(raiz, elem) == null) {
            if (raiz.getDato() == elem) {
                if (raiz.getDerecho() == null && raiz.getIzquierdo() == null) {
                    raiz = null;
                } else {
                    if (raiz.getIzquierdo() != null && raiz.getDerecho() != null) {
                        x = raiz.getIzquierdo();
                        while (x.getDerecho() != null) {
                            x = x.getDerecho();
                        }
                        raiz.dato = x.getDato();
                        Eliminar(raiz.getIzquierdo(),raiz.getIzquierdo().getDato());
                    } else {
                        if (raiz.getIzquierdo() != null && raiz.getDerecho() == null) {
                           // x = raiz.getIzquierdo();
                            raiz.dato = raiz.getIzquierdo().getDato();
                            Eliminar(raiz.getIzquierdo(), raiz.getIzquierdo().getDato());
                        } else {
                            if (raiz.getDerecho() != null && raiz.getIzquierdo() == null) {
                              //  x = raiz.getDerecho();
                                raiz.dato = raiz.getDerecho().getDato();
                                Eliminar(raiz.getDerecho(), raiz.getDerecho().getDato());
                            }
                        }

                    }
                }
            } else {
                System.out.println("No se encuentra el elemento");
            }
        } else {
            if (raiz.getIzquierdo().getDato() == elem) {
                Eliminar(raiz.getIzquierdo(), raiz.getIzquierdo().getDato());
            } else {
                if (raiz.getDerecho().getDato() == elem) {
                    Eliminar(raiz.getDerecho(), raiz.getDerecho().getDato());
                }
            }


            /* Nodo aux=null;
        if (padre != null) {
            if (padre.getIzquierdo().getDato() == elem) {
                if (padre.getIzquierdo().getIzquierdo() != null) {
                    aux=padre.getIzquierdo().getIzquierdo();
                    padre.izquierdo=aux;
                }else{}*/
 /*     if (raiz.getDerecho() != null && raiz.getIzquierdo() == null) {
                    if (padre.getDerecho() == raiz) {
                        padre.derecho = raiz.derecho;
                        raiz.derecho = null;
                    } else {
                        padre.izquierdo = raiz.derecho;
                        raiz.derecho = null;
                    }
                } else {
                    if (raiz.getDerecho() == null && raiz.getIzquierdo() != null) {
                        if (padre.getDerecho() == raiz) {
                            padre.derecho = raiz.derecho;
                            raiz.derecho = null;
                        } else {
                            padre.izquierdo = raiz.derecho;
                            raiz.derecho = null;
                        }
                    } else {
                        if (padre.getDerecho() == raiz) {
                            padre.derecho = null;
                        } else {
                            padre.izquierdo = null;
                        }
                    }
                }*/
        }

    }

    public static Nodo BPadre(Nodo raiz, int elem) {
        if ((raiz.getDerecho() == null && raiz.getIzquierdo() == null) || raiz.getDato() == elem) {
            return null;
        } else {
            if ((raiz.getIzquierdo().getDato() == elem) || (raiz.getDerecho().getDato() == elem)) {
                System.out.println(elem);
                return raiz;
            } else {
                if (raiz.getDato() > elem) {
                    return BPadre(raiz.getIzquierdo(), elem);
                } else {
                    return BPadre(raiz.getDerecho(), elem);
                }

            }
        }
    }
    
   
}
