import javax.naming.Name;

public class StringFormatter {

    public StringFormatter(){

    }

    public String formatString(String string){
        String formattedName = "";
        int namelength = Math.round((19 - string.length())/2);

        for(int i = 0; i < 19; i++){
            if(i < namelength || i > (string.length() + namelength)){
                formattedName += " ";

            }else {
                formattedName += string.substring(0, Math.min(string.length(), 18));
                i = string.length() + i;
            }
        }
        return formattedName;
    }
}
