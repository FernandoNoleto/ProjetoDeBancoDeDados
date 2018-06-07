
package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Controller {
    private void AcessarBanco(){
        ConnectionFactory conexao = new ConnectionFactory();
        try{
            conexao.getConnection();
            System.out.println("Deu certo");
        }
        catch(Exception e){
            System.out.println("ERRO: "+e);
        }
    }
    
    public boolean Simular(String equipe1, String equipe2) throws SQLException{
        
        System.out.println(equipe1);
        System.out.println(equipe2);
        boolean vencedor = true;
        
        if(equipe1.equals(equipe2)){
            JOptionPane.showMessageDialog(null, "Não escolha 2 seleções iguais seu doente mental", "Alerta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from equipes.jogadores");
            ResultSet rs = stmt.executeQuery();
            
            int time1 = 0;
            int time2 = 0;
            int count1 = 0;
            int count2 = 0;
            int ranking1 = 0;
            int ranking2 = 0;
            
            
            while (rs.next()) {
                String aux = rs.getString("selecao");
//                System.out.println("------------------------------");
//                System.out.println("Jogador:. "+rs.getString("nome"));
//                System.out.println("Selecao:. "+rs.getString("selecao"));
//                System.out.println("Overall:. "+rs.getInt("overall"));
//                System.out.println("Posição:. "+rs.getString("posicao"));
                
                if(equipe1.equals(aux)){
                    count1++;
                    time1 += rs.getInt("overall");
                    ranking1 = rs.getInt("ranking_fifa");
                }
                if(equipe2.equals(aux)){
                    count2++;
                    time2 += rs.getInt("overall");
                    ranking2 = rs.getInt("ranking_fifa");
                }
            }
            
            float media_1 = 0;
            float media_2 = 0;
            
            try{media_1 = (float)time1/count1;}catch(Exception e){System.out.println(e);}
            try{media_2 = (float)time2/count2;}catch(Exception e){System.out.println(e);}
            
            //Peso da media dos jogadores: 70%
            //Peso do ranking da fifa: 30%
            float total_1 = (float) ((media_1 * 0.7) + ((100 - ranking1) * 0.3));
            float total_2 = (float) ((media_2 * 0.7) + ((100 - ranking2) * 0.3));
            
            
            System.out.println("Total "+equipe1+":. "+total_1);
            System.out.println("Total "+equipe2+":. "+total_2);
            
            //15% de aleatoriedade
            if(total_1 >= total_2 && !Zebra()){
                JOptionPane.showMessageDialog(null, equipe1+" vence!");    
                System.out.println(equipe1+ " vence!");
            }
            else{
                JOptionPane.showMessageDialog(null, equipe2+" vence!");
                System.out.println(equipe2+ " vence!");
                vencedor = false;
            }
            
            System.out.println("Media dos jogadores "+equipe1+":. "+media_1);
            System.out.println("Media dos jogadores "+equipe2+":. "+media_2);
            
            
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ ex);
        }
        
        return vencedor;
    }
    
    public boolean Zebra(){
        //Random ran = new Random();
        int x = new Random().nextInt(101);
        if(x > 85)
            System.out.println("ZEBRA!");
        //15% de aleatoriedade
        return (x > 85);
        
        
    }
    

    public static <K, V extends Comparable<? super V>> Map<K, V> ordenarInversamente
        (Map<K, V> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<K, V> comparingByValue().reversed())
            // Type here -----^ reversed() here -------^
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
            ));
    }

    
    
    //Retorna uma lista com os 2 primeiros colocados
    public ArrayList<String> grupoA() throws SQLException{
        
        //Russia, Arábia Saudita, Egito, Uruguai
        int rus = 0, asd = 0, egi = 0, uru = 0;
        
        /*-----------------------------*/
        if(Simular("Russia", "Saudi Arabia"))
            rus+=3;
        else
            asd+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Russia", "Egypt"))
            rus+=3;
        else
            egi+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Russia", "Uruguay"))
            rus+=3;
        else
            uru+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Egypt", "Saudi Arabia"))
            egi+=3;
        else
            asd+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Uruguay", "Saudi Arabia"))
            uru+=3;
        else
            asd+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Egypt", "Uruguay"))
            egi+=3;
        else
            uru+=3;
        /*-----------------------------*/
        
        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Russia", rus);
        classificacao.put("Saudi Arabia", asd);
        classificacao.put("Egypt", egi);
        classificacao.put("Uruguay", uru);
        
        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);
        
        ArrayList<String> classificados = new ArrayList<>();
        classificados.add(classificacao.entrySet().iterator().next().getKey());
        classificacaoFinal.remove(classificacao.entrySet().iterator().next().getKey());
        classificados.add(classificacao.entrySet().iterator().next().getKey());
        
        return classificados;
    }
    
    

}
