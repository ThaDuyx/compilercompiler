import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

class faux{ // collection of non-OO auxiliary functions (currently just error)
    public static void error(String msg){
	System.err.println("Interpreter error: "+msg);
	System.exit(-1);
    }
}

abstract class AST{
}

class Start extends AST{
    String result="";
    public List<DataTypeDef> datatypedefs;
    Start(List<DataTypeDef> datatypedefs){
        this.datatypedefs=datatypedefs;


    }
    public String translate(){
        //Hardcoding java syntax
        result += "import java.util.*;\n";
        result += "abstract class AST{}\n\n";
        //Going through all the translate methods
        for (DataTypeDef data : datatypedefs)
            result += data.translate();

            return result;
    }
}

class DataTypeDef extends AST{
    public String dataTypeName;
    public String functionHead;
    String result ="";
    String spaces ="  ";
    public List<Alternative> alternatives;
    DataTypeDef(String dataTypeName, String functionHead, List<Alternative> alternatives){
	this.dataTypeName=dataTypeName;
	this.functionHead=functionHead;
	this.alternatives=alternatives;
    }

    public String translate(){
        result += ("abstract class " + dataTypeName +" extends AST {\n");
        result += ( spaces + "public abstract " + functionHead +";\n};\n");

        for(Alternative alter : alternatives){
            result += "\nclass ";
            //receiving datatype from Alterative class
            alter.datatype = dataTypeName;
            alter.expr = functionHead;
            result += alter.translate() +"\n}\n";

        }

        return result;
    }
}

class Alternative extends AST{
    public String constructor;
    public List<Argument> arguments;
    public String code;
    String spaces = "  ";
    String datatype;
    String expr;
    String result="";
    Alternative(String constructor, List<Argument> arguments,  String code){
	this.constructor=constructor;
	this.arguments=arguments;
	this.code=code;
    }

    public String translate(){

        result += constructor + " extends " + datatype +"{\n";
        for (Argument args : arguments){
            result += spaces +  args.translate() + ";" + "\n";
        }

        result += spaces + constructor + "(";
        for (Argument args : arguments){
            if(!args.equals(arguments.get(arguments.size() - 1))){
                result += args.type+ " " + args.name + ", ";
            } else {
                result += args.type + " " + args.name + ")";
            }
        }

        result += "{";
        for (Argument args : arguments){
            if(!args.equals(arguments.get(arguments.size() - 1))){
                result += "this." + args.name+ "=" + args.name + "; ";
            } else {
                result += "this." + args.name + "=" + args.name + ";";
            }
        }

        result += " }\n" + spaces + "public " +  expr + " " + code;

        return result;
    }

}

class Argument extends AST{
    public String type;
    public String name;
    String result="";
    Argument(String type, String name){this.type=type; this.name=name;}

    public String translate(){
        result += type + " " + name;

        return result;
    }
}




































































