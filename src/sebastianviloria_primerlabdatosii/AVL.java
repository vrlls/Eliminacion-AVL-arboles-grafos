/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sebastianviloria_primerlabdatosii;

/**
 *
 * @author seviloria
 */
public class AVL {

    public static Nodo rotacionDerecha(Nodo x) {
        Nodo h = x.izquierdo;
        x.izquierdo = h.derecho;
        h.derecho = x;

        setFactorBalance(x);
        setFactorBalance(h);

        return h;
    }

    public static Nodo rotacionDobleDerecha(Nodo x) {
        x.izquierdo = rotacionIzquierda(x.izquierdo);
        return rotacionDerecha(x);
    }

    public static Nodo rotacionIzquierda(Nodo x) {
        Nodo h = x.derecho;
        x.derecho = h.izquierdo;
        h.izquierdo = x;

        setFactorBalance(x);
        setFactorBalance(h);

        return h;
    }

    public static Nodo rotacionDobleIzquierda(Nodo x) {
        x.derecho = rotacionDerecha(x.derecho);
        return rotacionIzquierda(x);
    }

    public static Nodo insertar(Nodo nodo, int dato) {
        if (nodo == null) {
            return (new Nodo(dato));
        }

        if (dato < nodo.getInfo(nodo)) {
            nodo.izquierdo = insertar(nodo.izquierdo, dato);
        } else if (dato > nodo.getInfo(nodo)) {
            nodo.derecho = insertar(nodo.derecho, dato);
        } else {
            return nodo;
        }

        setFactorBalance(nodo);

        if (getFactorBalance(nodo) == -2 && getFactorBalance(nodo.izquierdo) != 1) {
            return rotacionDerecha(nodo);
        }

        if (getFactorBalance(nodo) == 2 && getFactorBalance(nodo.derecho) != -1) {
            return rotacionIzquierda(nodo);
        }

        if (getFactorBalance(nodo) == 2 && getFactorBalance(nodo.derecho) == -1) {
            return rotacionDobleIzquierda(nodo);
        }

        if (getFactorBalance(nodo) == -2 && getFactorBalance(nodo.izquierdo) == 1) {
            return rotacionDobleDerecha(nodo);
        }

        return nodo;
    }

    public static int getAltura(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return (1 + Math.max(getAltura(raiz.izquierdo), getAltura(raiz.derecho)));
        }

    }

    public static int getFactorBalance(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return raiz.factorBalance;
    }

    public static void setFactorBalance(Nodo raiz) {
        if (raiz != null) {
            raiz.factorBalance = getAltura(raiz.derecho) - getAltura(raiz.izquierdo);
        }
    }

    public static Nodo buscarAB(Nodo padre, int dato) {
        if (padre.getDerecho() == null && padre.getIzquierdo() == null) {
            return null;
        } else {
            if (padre.getDerecho().getDato() == dato) {
                return padre.getDerecho();
            } else {
                if (padre.getIzquierdo().getDato() == dato) {
                    return padre.getIzquierdo();
                } else {
                    if (buscarAB(padre.getIzquierdo(), dato).getDato() == dato) {
                        return padre.getIzquierdo();
                    } else {
                        if (buscarAB(padre.getDerecho(), dato).getDato() == dato) {
                            return padre.getDerecho();
                        }
                    }
                }//return buscarAB(raiz.getIzquierdo(), dato) || buscarAB(raiz.getDerecho(), dato);
            }
        }
        return null;
    }


    /*public static boolean buscarABB(Nodo raiz, int dato) {
        if (raiz == null) {
            return false;
        } else {
            if (raiz.getDato() == dato) {
                return true;
            } else {
                if (dato > raiz.getDato()) {
                    return buscarAB(raiz.getIzquierdo(), dato);
                } else {
                    return buscarAB(raiz.getDerecho(), dato);
                }
            }
        }
    }*/
}
