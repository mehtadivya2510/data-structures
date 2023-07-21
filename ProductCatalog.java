import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog {

    HashMap<String, ArrayList<String>> hm=new HashMap<>();
    public static void main(String[] args) {
        ArrayList<String> intsAsStrings= new ArrayList<>(Arrays.asList("5", "100", "200", "-1"));
        convertToIntegerOddOnly(intsAsStrings);
    }

    public static List<Integer> convertToIntegerOddOnly(ArrayList<String> intsAsStrings){
        final List<Integer> list=intsAsStrings.stream().map(item-> Integer.parseInt(item)).filter(item-> item%2!=0).collect(Collectors.toList());
        return list;
    }

    public static ArrayList<Integer> temp(int item){
        final ArrayList<Integer> list;
        if(item==0){
            list=new ArrayList<Integer>();
        }else if(item==1){
            list=new ArrayList<Integer>();
        }else{
            list=new ArrayList<Integer>();
        }
        return list;
    }

    static class Graph{
        Node root;

        public ArrayList<Node> getHierarchy(int targetId){
            ArrayList<Node> path= new ArrayList<>();;
            if(getHierarchyUtil(targetId,root,path)){
                return path;
            }else{
                return null;
            }
        }
        Boolean getHierarchyUtil(int targetId,Node parent,ArrayList<Node> path){
            if(targetId==parent.id){
                path.add(parent);
                return true;
            }
            for (Node temp: parent.children){
                if(getHierarchyUtil(targetId,temp,path)){
                    path.add(parent);
                    return true;
                }
            }
            return false;
        }
    }

    static class Node{
        int id;
        String name;
        String url;
        ArrayList<Node> children;

    }
}

