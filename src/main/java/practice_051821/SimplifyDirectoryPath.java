package practice_051821;


/*
Given a string A representing an absolute path for a file (Unix-style).
Return the string A after simplifying the absolute path.
Note:
Absolute path always begin with ’/’ ( root directory ).
Path will not have whitespace characters.
Input Format
The only argument given is string A.
Output Format
Return a string denoting the simplified absolue path for a file (Unix-style).
For Example
Input 1:
    A = "/home/"
Output 1:
    "/home"
Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
 */
import java.util.Stack;

public class SimplifyDirectoryPath {

    private String getSimplifiedPath(String input){
        String[] directories = input.split ("/");
        Stack<String> folderStack = new Stack<> ();
        String simplified = "";
        for(int i = 1; i<directories.length;i++){
            if(!directories[i].equals("..")) {
                if(directories[i].equals(".")){
                    continue;
                }
                if(folderStack.isEmpty() || (!folderStack.isEmpty() && !((directories[i].equals("/") && folderStack.peek().equals ("/"))))) {
                    folderStack.push ("/"+directories[i]);
                }
            }else{
                if(!folderStack.isEmpty()){
                    folderStack.pop();
                }
            }
        }
        while(!folderStack.isEmpty ()){
            simplified = folderStack.pop() +simplified ;
        }
        return simplified;
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
        String simplifiedPath = simplifyDirectoryPath.getSimplifiedPath ("/a/./b/../../c/");
        System.out.println (simplifiedPath);
    }
}
