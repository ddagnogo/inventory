/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 */
 public class ItemInventaire extends ItemBase {

     private int quantite; // Quantité de l'item

     // CONSTRUCTEUR
     /**
      * Construit un item avec la description, le prix et la description pass√©s
      * en param√®tres.
      *
      * @param desc la description
      * @param prix le prix
      * @param quant la quantite
      */
     public ItemInventaire(String desc, double prix, int quant) {
         super(desc, prix);
         this.quantite = quant;
     }

     /**
      * Renvoie la quantite de l'item.
      *
      * @return la quantite de l'item.
      */
     public int getQuantite() {
         return this.quantite;
     }

     /**
      * Modifie la quantite de l'item.
      *
      * @param nouvelleQuantite la nouvelle quantite de l'item
      */
     public void setQuantite(int nouvelleQuantite) {
         this.quantite = nouvelleQuantite;
     }

     /**
      * D√©termine si deux items sont √©gaux Les classes d√©rivant de cette
      * classe d√©cideront ce qui fait que deux items sont √©gaux.
      *
      * @param nouveauPrix le nouveau prix de l'item
      */
     public boolean equals(Object o) {
         return o != null
                 && o.getClass() == this.getClass()
                 && getDescription().equals(((ItemInventaire) o).getDescription())
                 && getPrix() == (((ItemInventaire) o).getPrix())
                 && quantite == (((ItemInventaire) o).getQuantite());
     }

     public String toString() {
         return quantite + " " + getPrix() + " " + getDescription();
     }
 }
