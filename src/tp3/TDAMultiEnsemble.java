/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author dognimedagnogo
 */
public interface TDAMultiEnsemble<T> {

    /**
     * Retourne true si le multiEnsemble est vide.
     *
     * @return true si ce multiEnsemble est vide, false sinon
     */
    public abstract boolean estVide();

    /**
     * Vide ce multiEnsemble
     */
    public abstract void vider();

    /**
     * Retourne le nombre d'elements distincts
     *
     * @return le nombre d'elements distincts de ce multiEnsemble
     */
    public abstract int cardDistincts();

    /**
     * Retourne le nombre total d'elements
     *
     * @return le nombre total d'elements incluant les doublons
     */
    public abstract int cardTotale();

    /**
     * Retourne true si ce multiEnsemble contient au moins une occurrence de
     * l'element
     *
     * @param element element a verifier
     * @return true si element est dans le multiEnsemble (au moins une
     * occurrence), false sinon
     */
    public abstract boolean estElement(T element);

    /**
     * Retourne le nombre d'occurrences de l'element dans ce multiEnsemble
     *
     * @param element element a verifier
     * @return le nombre d'occurrences d'element dans ce multiEnsemble
     */
    public abstract int nbOccurrences(T element);

    /**
     * Cherche element dans le multiEnsemble.
     *
     * @param element ÈlÈment ‡ chercher
     * @return une occurrence de l'ÈlÈment trouvÈ si au moins une occurrence,
     * null si absent
     */
    public abstract T trouverElement(T element);

    /**
     * Ajoute une occurrence de cet element au multiEnsemble
     *
     * @param element element a ajouter
     * @return le nombre d'occurrences de element dans le multiEnsemble APRES
     * l'ajout
     */
    public abstract int ajouter(T element);

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
    public abstract int ajouter(T element, int nbCopies);

    /**
     * Retire une occurrence de cet element du multiEnsemble. Si l'element etait
     * absent, il le demeure. Ceci veut dire que si l'on retire un element
     * absent et qu'ensuite on l'ajoute, son nombre d'occurrences sera egal a 1.
     *
     * @param element element a retirer
     * @return le nombre d'occurrences de element dans le multiEnsemble APRES le
     * retrait
     */
    public abstract int retirer(T element);

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
    public abstract int retirer(T element, int nbCopies);

    /**
     * Retire toutes les occurrences de element de ce multiEnsemble. Si
     * l'element etait absent, il le demeure.
     *
     * @param element element a retirer
     * @return le nombre d'occurrences de element dans le multiEnsemble AVANT
     * son Èlimination
     */
    public abstract int eliminer(T element);

    /**
     * Ajoute ‡ cet ensemble tous les ÈlÈments de autre. Le multiEnsemble autre
     * sera vidÈ par l'opÈration. Il s'agit donc d'un transfert des ÈlÈments de
     * autre dans cet ensemble.
     *
     * @param autre multiEnsemble dont les elements seront transferes dans cet
     * ensemble
     * @return le nombre total d'ÈlÈments transfÈrÈs (toutes les occurrences).
     */
    public abstract int transfert(TDAMultiEnsemble<T> autre);

    /**
     * Retourne la chaÓne correspondant au contenu du multiEnsemble. La mÈthode
     * toString de T sera utilisÈe.
     *
     * @return la chaine
     */
    public abstract String toString();

    /**
     * DÈtermine si ce multiEnsemble contient les mÍmes ÈlÈments en mÍme nombre
     * que celui reprÈsentÈ par o.
     *
     * @param o l'objet ‡ comparer avec ce multiEnsemble
     * @return true si ce multiEnsemble contient les mÍmes ÈlÈments en mÍme
     * nombre que o
     */
    public abstract boolean equals(Object o);
}
