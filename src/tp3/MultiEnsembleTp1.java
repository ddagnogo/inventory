package tp3;

import java.util.ArrayList;

/**
 *
 * @since Mars 2013
 */
 public class MultiEnsembleTp1<T> implements TDAMultiEnsemble<T> {

     private ArrayList<T> multEns;

     /*
      * Création d'un nouvel multiEnsemble vide
      */
     public MultiEnsembleTp1() {
         multEns = new ArrayList<T>();
     }

     /**
      * Retourne true si le multiEnsemble est vide.
      *
      * @return true si ce multiEnsemble est vide, false sinon
      */
     public boolean estVide() {
         return multEns.isEmpty();
     }

     /**
      * Vide ce multiEnsemble
      */
     public void vider() {
         multEns.clear();
     }

     /**
      * Retourne le nombre d'elements distincts
      *
      * @return le nombre d'elements distincts de ce multiEnsemble
      */
     public int cardDistincts() {
         int i = 0;
         int taille = cardTotale();
         int elemsDistincts = 0;
         while (i < taille) {
             if (i == multEns.lastIndexOf(multEns.get(i))) {
                 elemsDistincts = elemsDistincts + 1;
             }
             i++;
         }
         return elemsDistincts;
     }

     /**
      * Retourne le nombre total d'elements
      *
      * @return le nombre total d'elements incluant les doublons
      */
     public int cardTotale() {
         return multEns.size();
     }

     /**
      * Méthode accède au élément à une position donnée.
      *
      * @param index
      * @return l'element à une position donnée
      */
     public T getIndex(int index) {
         return multEns.get(index);
     }

     /**
      * Retourne true si ce multiEnsemble contient au moins une occurrence de
      * l'element
      *
      * @param element element a verifier
      * @return true si element est dans le multiEnsemble (au moins une
      * occurrence), false sinon
      */
     public boolean estElement(T element) {
         return multEns.contains(element);
     }

     /**
      * Retourne le nombre d'occurrences de l'element dans ce multiEnsemble
      *
      * @param element element a verifier
      * @return le nombre d'occurrences d'element dans ce multiEnsemble
      */
     public int nbOccurrences(T element) {
         int nbOcc = 0;
         int taille = cardTotale();
         for (int i = 0; i < taille; i++) {
             if (multEns.get(i).equals(element)) {
                 nbOcc = nbOcc + 1;
             }
         }
         return nbOcc;
     }

     /**
      * Cherche element dans le multiEnsemble.
      *
      * @param element ÈlÈment ‡ chercher
      * @return une occurrence de l'ÈlÈment trouvÈ si au moins une occurrence,
      * null si absentc¢
      */
     public T trouverElement(T element) {
         T elem = null;
         boolean trouve = false;
         int i = 0;
         while (i < multEns.size() && !trouve) {
             if (multEns.get(i).equals(element)) {
                 trouve = true;
                 elem = element;
             } else {
                 i++;
             }
         }
         return elem;
     }

     /**
      * Ajoute une occurrence de hcet element au multiEnsemble
      *
      * @param element element a ajouter
      * @return le nombre d'occurrences de element dans le multiEnsemble APRES
      * l'ajout
      */
     public int ajouter(T element) {
         multEns.add(element);
         return nbOccurrences(element);
     }

     /**
      * Ajoute nbCopies occurrences de cet element au multiEnsemble. nbCopies ne
      * doit pas Ítre nÈgatif.
      *
      * @param element element a ajouter
      * @param nbCopies nombre d'occurrences a ajouter
      * @throws NombreOccurrencesException si nbCopies est nÈgatif.
      * @return le nombre d'occurrences de element dans le multiEnsemble APRES
      * l'ajout
      */
     public int ajouter(T element, int nbCopies) {
         int i = 0;
         if (nbCopies < 0) {
             throw new NombreOccurrencesException("*** Le nombre de copies "
                     + "ne doit pas être négatif ***");
         }
         while (i < nbCopies) {
             multEns.add(element);
             i++;
         }
         return nbOccurrences(element);
     }

     /**
      * Retire une occurrence de cet element du multiEnsemble. Si l'element etait
      * absent, il le demeure. Ceci veut dire que si l'on retire un element
      * absent et qu'ensuite on l'ajoute, son nombre d'occurrences sera egal a 1.
      *
      * @param element element a retirer
      * @return le nombre d'occurrences de element dans le multiEnsemble APRES le
      * retrait
      */
     public int retirer(T element) {
         multEns.remove(element);
         return nbOccurrences(element);
     }

     /**
      * Retire nbCopies occurrences de cet element du multiEnsemble. nbCopies ne
      * doit pas Ítre nÈgatif.
      *
      * @param element element a retirer
      * @param nbCopies nombre d'occurrences a retirer
      * @throws NombreOccurrencesException si nbCopies est nÈgatif.
      * @return le nombre d'occurrences de element dans le multiEnsemble APRES le
      * retrait
      */
     public int retirer(T element, int nbCopies) {
         int i = 0;
         if (nbCopies < 0) {
             throw new NombreOccurrencesException("*** Le nombre de copies "
                     + "ne doit pas être négatif ***");
         }
         while (i < nbCopies) {
             multEns.remove(element);
             i++;
         }
         return nbOccurrences(element);
     }

     /**
      * Retire toutes les occurrences de element de ce multiEnsemble. Si
      * l'element etait absent, il le demeure.
      *
      * @param element element a retirer
      * @return le nombre d'occurrences de element dans le multiEnsemble AVANT
      * son Èlimination
      */
     public int eliminer(T element) {
         int nbOccAvantElimination = nbOccurrences(element);
         int taille = cardTotale();
         ArrayList<T> temp = new ArrayList<T>();
         int i = 0;
         while (i < taille) {
             if (!element.equals(multEns.get(i))) {
                 temp.add(multEns.get(i));
             }
             i++;
         }
         vider();
         multEns = temp;
         return nbOccAvantElimination;
     }

     /**
      * Ajoute ‡ cet ensemble tous les ÈlÈments de autre. Le multiEnsemble autre
      * sera vidÈ par l'opÈration. Il s'agit donc d'un transfert des ÈlÈments de
      * autre dans cet ensemble.
      *
      * @param autre multiEnsemble dont les elements seront transferes dans cet
      * ensemble
      * @return le nombre total d'ÈlÈments transfÈrÈs (toutes les occurrences).
      */
     public int transfert(TDAMultiEnsemble<T> autre) {
         int nbTransferts;
         for (int i = 0; i < ((MultiEnsembleTp1<T>) autre).multEns.size(); ++i) {
             this.ajouter(((MultiEnsembleTp1<T>) autre).multEns.get(i));
         }
         nbTransferts = autre.cardTotale();
         autre.vider();
         return nbTransferts;
     }

     /**
      * Retourne la chaÓne correspondant au contenu du multiEnsemble. La mÈthode
      * toString de T sera utilisÈe.
      *
      * @return la chaine
      */
     public String toString() {
         String chaine = "";
         int taille = cardTotale();
         for (int i = 0; i < taille; i++) {
             if (i == multEns.indexOf(multEns.get(i))) {
                 chaine += multEns.get(i).toString() + "\n";


                 //System.out.println((ItemInventaire) multEns.get(i).getPrix());


             }
         }

         return chaine;
     }

     /**
      * DÈtermine si ce multiEnsemble contient les mÍmes ÈlÈments en mÍme nombre
      * que celui reprÈsentÈ par o.
      *
      * @param o l'objet ‡ comparer avec ce multiEnsemble
      * @return true si ce multiEnsemble contient les mÍmes ÈlÈments en mÍme
      * nombre que o
      */
     public boolean equals(Object o) {
         int taille = cardTotale();
         return o != null
                 && o.getClass() == this.getClass()
                 && multEns.size() == (((MultiEnsembleTp1) o).multEns).size()
                 && memeElements(multEns, o);
     }

     /**
      * Méthode qui détermine si ce multiEnsemble contient les mêmes élements que
      * celui representé par o.
      *
      * @param multEns ArrayList contient les élements du multiEnsemble
      * @param o l'objet à comparer avec ce multiEnsemble
      * @return true si ce multiEnsemble contient les mêmes élements que o
      */
     private boolean memeElements(ArrayList<T> multEns, Object o) {
         boolean lesElementsIdentiques = false;
         int taille = cardTotale();
         // Si le contenu de multi ensemble est vide
         // S'il n'y a pas un élement represeté par o
         if (taille == 0 && (((MultiEnsembleTp1) o).multEns).size() == 0) {
             lesElementsIdentiques = true;
         } else {
             // S'il y a des élements representés par o ou par le multiEnsemble
             for (int i = 0; i < taille; i++) {
                 if (multEns.contains(((MultiEnsembleTp1) o).multEns.get(i))) {
                     lesElementsIdentiques = true;
                 }
             }
         }
         return lesElementsIdentiques;
     }
 }
