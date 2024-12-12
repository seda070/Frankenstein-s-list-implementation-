import java.util.Iterator;
import list.FrankensteinList;
import list.Node;

public class Main {
    public static void main(String...args) {
      FrankensteinList <Integer> fList = new FrankensteinList <>();
      fList.add(4);
      fList.add(8);
      fList.add(99);
      fList.add(23);
      fList.add(4);
      fList.add(455);
      fList.add(-7);
      Iterator <Node <Integer>>nIterator = fList.getNIterator();
      while(nIterator.hasNext()) {
         System.err.print(nIterator.next() + " ");
      }
      System.out.println();
      Iterator <Node <Integer>> pIterator = fList.getPIterator();
      while(pIterator.hasNext()) {
         System.out.print(pIterator.next() + " ");
      }
      System.out.println();
      Iterator <Node<Integer>> aIterator = fList.getAIterator();
      while (aIterator.hasNext()) {
         System.out.print(aIterator.next() + " ");
      } 
      Iterator <Node<Integer>> dIterator = fList.getDIterator();
      while(dIterator.hasNext()) {
        System.out.print(dIterator.next() + " ");
      }
      System.out.println();
      FrankensteinList <Double> fList2  = new FrankensteinList<>();
      fList2.add(24.5);
      fList2.add(44.5);
      fList2.add(4.565);
    }

}
