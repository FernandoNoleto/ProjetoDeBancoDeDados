
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
        
        //System.out.println(equipe1);
        //System.out.println(equipe2);
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
            
            
            //System.out.println("Total "+equipe1+":. "+total_1);
            //System.out.println("Total "+equipe2+":. "+total_2);
            
            //15% de aleatoriedade
            if(total_1 >= total_2 && !Zebra()){
                //JOptionPane.showMessageDialog(null, equipe1+" vence!");    
                //System.out.println(equipe1+ " vence!");
            }
            else{
                //JOptionPane.showMessageDialog(null, equipe2+" vence!");
                //System.out.println(equipe2+ " vence!");
                vencedor = false;
            }
            
            //System.out.println("Media dos jogadores "+equipe1+":. "+media_1);
            //System.out.println("Media dos jogadores "+equipe2+":. "+media_2);
            
            
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERRO!"+ ex);
        }
        
        return vencedor;
    }
    
    public String Simular(String equipe1, String equipe2, int gamba) throws SQLException{
        
        //System.out.println(equipe1);
        //System.out.println(equipe2);
        
        String vencedor = equipe1;
        
        if(equipe1.equals(equipe2)){
            JOptionPane.showMessageDialog(null, "Não escolha 2 seleções iguais seu doente mental", "Alerta", JOptionPane.ERROR_MESSAGE);
            return "";
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
            
            
            //System.out.println("Total "+equipe1+":. "+total_1);
            //System.out.println("Total "+equipe2+":. "+total_2);
            
            //15% de aleatoriedade
            if(total_1 >= total_2 && !Zebra()){
                //JOptionPane.showMessageDialog(null, equipe1+" vence!");    
                //System.out.println(equipe1+ " vence!");
            }
            else{
                //JOptionPane.showMessageDialog(null, equipe2+" vence!");
                //System.out.println(equipe2+ " vence!");
                vencedor = equipe2;
            }
            
            //System.out.println("Media dos jogadores "+equipe1+":. "+media_1);
            //System.out.println("Media dos jogadores "+equipe2+":. "+media_2);
            
            
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


    
    //Retorna uma lista com os 2 primeiros colocados do grupo A
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
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);
        
        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo B
    public ArrayList<String> grupoB() throws SQLException{
        
        //Portugal, Spain, Marrocos, Irã
        int por = 0, esp = 0, mar = 0, ira = 0;
        
        /*-----------------------------*/
        if(Simular("Portugal", "Spain"))
            por+=3;
        else
            esp+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Portugal", "Marrocos"))
            por+=3;
        else
            mar+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Portugal", "Iran"))
            por+=3;
        else
            ira+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Marrocos", "Spain"))
            mar+=3;
        else
            esp+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Iran", "Spain"))
            ira+=3;
        else
            esp+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Marrocos", "Iran"))
            mar+=3;
        else
            ira+=3;
        /*-----------------------------*/
        
        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Portugal", por);
        classificacao.put("Spain", esp);
        classificacao.put("Marrocos", mar);
        classificacao.put("Iran", ira);
        
        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);
        
        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);
        
        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo C
    public ArrayList<String> grupoC() throws SQLException{

        //França, Austrália, Peru, Denmark
        int fra = 0, aus = 0, per = 0, din = 0;

        /*-----------------------------*/
        if(Simular("France", "Australia"))
            fra+=3;
        else
            aus+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("France", "Peru"))
            fra+=3;
        else
            per+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("France", "Denmark"))
            fra+=3;
        else
            din+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Peru", "Australia"))
            per+=3;
        else
            aus+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Denmark", "Australia"))
            din+=3;
        else
            aus+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Peru", "Denmark"))
            per+=3;
        else
            din+=3;
        /*-----------------------------*/

        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("France", fra);
        classificacao.put("Australia", aus);
        classificacao.put("Peru", per);
        classificacao.put("Denmark", din);

        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);

        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);

        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo D
    public ArrayList<String> grupoD() throws SQLException{

        //Argentina, Islândia, Croácia, Nigéria
        int arg = 0, isl = 0, cro = 0, nig = 0;

        /*-----------------------------*/
        if(Simular("Argentina", "Iceland"))
            arg+=3;
        else
            isl+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Argentina", "Croatia"))
            arg+=3;
        else
            cro+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Argentina", "Nigeria"))
            arg+=3;
        else
            nig+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Croatia", "Iceland"))
            cro+=3;
        else
            isl+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Nigeria", "Iceland"))
            nig+=3;
        else
            isl+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Croatia", "Nigeria"))
            cro+=3;
        else
            nig+=3;
        /*-----------------------------*/

        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Argentina", arg);
        classificacao.put("Iceland", isl);
        classificacao.put("Croatia", cro);
        classificacao.put("Nigeria", nig);

        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);

        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);

        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo E
    public ArrayList<String> grupoE() throws SQLException{

        //Brasil, Suíça, Costa Rica, Sérvia
        int bra = 0, sui = 0, cos = 0, ser = 0;

        /*-----------------------------*/
        if(Simular("Brazil", "Switzerland"))
            bra+=3;
        else
            sui+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Brazil", "Costa Rica"))
            bra+=3;
        else
            cos+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Brazil", "Serbia"))
            bra+=3;
        else
            ser+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Costa Rica", "Switzerland"))
            cos+=3;
        else
            sui+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Serbia", "Switzerland"))
            ser+=3;
        else
            sui+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Costa Rica", "Serbia"))
            cos+=3;
        else
            ser+=3;
        /*-----------------------------*/

        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Brazil", bra);
        classificacao.put("Switzerland", sui);
        classificacao.put("Costa Rica", cos);
        classificacao.put("Serbia", ser);

        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);

        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);

        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo F
    public ArrayList<String> grupoF() throws SQLException{

        //Alemanha, Mexico, Suécia, Coreia do Sul
        int ale = 0, mex = 0, sue = 0, cor = 0;

        /*-----------------------------*/
        if(Simular("Germany", "Mexico"))
            ale+=3;
        else
            mex+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Germany", "Sweden"))
            ale+=3;
        else
            sue+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Germany", "Korea Republic"))
            ale+=3;
        else
            cor+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Sweden", "Mexico"))
            sue+=3;
        else
            mex+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Korea Republic", "Mexico"))
            cor+=3;
        else
            mex+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Sweden", "Korea Republic"))
            sue+=3;
        else
            cor+=3;
        /*-----------------------------*/

        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Germany", ale);
        classificacao.put("Mexico", mex);
        classificacao.put("Sweden", sue);
        classificacao.put("Korea Republic", cor);

        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);

        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);

        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo G
    public ArrayList<String> grupoG() throws SQLException{

        //Belgica, Panamá, Tunisia, Inglaterra
        int bel = 0, pan = 0, tun = 0, ing = 0;

        /*-----------------------------*/
        if(Simular("Belgium", "Panama"))
            bel+=3;
        else
            pan+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Belgium", "Tunisia"))
            bel+=3;
        else
            tun+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Belgium", "England"))
            bel+=3;
        else
            ing+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Tunisia", "Panama"))
            tun+=3;
        else
            pan+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("England", "Panama"))
            ing+=3;
        else
            pan+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Tunisia", "England"))
            tun+=3;
        else
            ing+=3;
        /*-----------------------------*/

        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Belgium", bel);
        classificacao.put("Panama", pan);
        classificacao.put("Tunisia", tun);
        classificacao.put("England", ing);

        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);

        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);

        return classificados;
    }
    
    //Retorna uma lista com os 2 primeiros colocados do grupo H
    public ArrayList<String> grupoH() throws SQLException{

        //Polonia, Senegal, Colombia, Japão
        int pol = 0, sen = 0, col = 0, jap = 0;

        /*-----------------------------*/
        if(Simular("Poland", "Senegal"))
            pol+=3;
        else
            sen+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Poland", "Colombia"))
            pol+=3;
        else
            col+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Poland", "Japan"))
            pol+=3;
        else
            jap+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Colombia", "Senegal"))
            col+=3;
        else
            sen+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Japan", "Senegal"))
            jap+=3;
        else
            sen+=3;
        /*-----------------------------*/
        /*-----------------------------*/
        if(Simular("Colombia", "Japan"))
            col+=3;
        else
            jap+=3;
        /*-----------------------------*/

        Map<String,Integer> classificacao = new HashMap<String, Integer>();
        classificacao.put("Poland", pol);
        classificacao.put("Senegal", sen);
        classificacao.put("Colombia", col);
        classificacao.put("Japan", jap);

        Map<String,Integer> classificacaoFinal = ordenarInversamente(classificacao);

        ArrayList<String> classificados = new ArrayList<>();
        
        String clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        classificacaoFinal.remove(clas);
        clas = classificacaoFinal.entrySet().iterator().next().getKey();
        classificados.add(clas);
        
        System.out.println(classificados);

        return classificados;
    }
    
    
    public ArrayList<String> oitavasDeFinal(
            ArrayList<String> clasGrupoA,
            ArrayList<String> clasGrupoB,
            ArrayList<String> clasGrupoC,
            ArrayList<String> clasGrupoD,
            ArrayList<String> clasGrupoE,
            ArrayList<String> clasGrupoF,
            ArrayList<String> clasGrupoG,
            ArrayList<String> clasGrupoH
    ) throws SQLException{
        ArrayList<String> classificados = new ArrayList<>();
        
        //Oitavas 1
        classificados.add(Simular(clasGrupoA.get(0), clasGrupoB.get(1), 0));
        //Oitavas 2
        classificados.add(Simular(clasGrupoA.get(1), clasGrupoB.get(0), 0));
        //Oitavas 3
        classificados.add(Simular(clasGrupoC.get(0), clasGrupoD.get(1), 0));
        //Oitavas 4
        classificados.add(Simular(clasGrupoC.get(1), clasGrupoD.get(0), 0));
        //Oitavas 5
        classificados.add(Simular(clasGrupoE.get(0), clasGrupoF.get(1), 0));
        //Oitavas 6
        classificados.add(Simular(clasGrupoE.get(1), clasGrupoF.get(0), 0));
        //Oitavas 7
        classificados.add(Simular(clasGrupoG.get(0), clasGrupoH.get(1), 0));
        //Oitavas 8
        classificados.add(Simular(clasGrupoG.get(1), clasGrupoH.get(0), 0));
        
        return classificados;
    }
    
    
    public ArrayList<String> quartasDeFinal(
            String clasOitavas1,
            String clasOitavas2,
            String clasOitavas3,
            String clasOitavas4,
            String clasOitavas5,
            String clasOitavas6,
            String clasOitavas7,
            String clasOitavas8
    ) throws SQLException{
        ArrayList<String> classificados = new ArrayList<>();
        
        //Quartas 1
        classificados.add(Simular(clasOitavas1, clasOitavas2, 0));
        //Quartas 2
        classificados.add(Simular(clasOitavas3, clasOitavas4, 0));
        //Quartas 3
        classificados.add(Simular(clasOitavas5, clasOitavas6, 0));
        //Quartas 4
        classificados.add(Simular(clasOitavas7, clasOitavas8, 0));
        
        
        return classificados;
    }
    
    
    public ArrayList<String> semiFinal(
            String clasQuartas1,
            String clasQuartas2,
            String clasQuartas3,
            String clasQuartas4
    ) throws SQLException{
        ArrayList<String> classificados = new ArrayList<>();
        
        //Semi-final 1
        classificados.add(Simular(clasQuartas1, clasQuartas2, 0));
        //Semi-final 2
        classificados.add(Simular(clasQuartas3, clasQuartas4, 0));
        
        
        
        return classificados;
    }
    
    public String Final(
            String clasSemi1,
            String clasSemi2
    ) throws SQLException{
        String campeao;
        
        //Final
        campeao = Simular(clasSemi1, clasSemi2, 0);
        return campeao;
    }
    
    public String simularCopaInteria() throws SQLException{
        
        ArrayList<String> classificadosGrupoA = grupoA();
        ArrayList<String> classificadosGrupoB = grupoB();
        ArrayList<String> classificadosGrupoC = grupoC();
        ArrayList<String> classificadosGrupoD = grupoD();
        ArrayList<String> classificadosGrupoE = grupoE();
        ArrayList<String> classificadosGrupoF = grupoF();
        ArrayList<String> classificadosGrupoG = grupoG();
        ArrayList<String> classificadosGrupoH = grupoH();
        
//        System.out.println(classificadosGrupoA);
//        System.out.println(classificadosGrupoB);
//        System.out.println(classificadosGrupoC);
//        System.out.println(classificadosGrupoD);
//        System.out.println(classificadosGrupoE);
//        System.out.println(classificadosGrupoF);
//        System.out.println(classificadosGrupoG);
//        System.out.println(classificadosGrupoH);
        
        
        //return "";
        
        ArrayList<String> classficadosOitavas = oitavasDeFinal(
                classificadosGrupoA,
                classificadosGrupoB,
                classificadosGrupoC,
                classificadosGrupoD,
                classificadosGrupoE,
                classificadosGrupoF,
                classificadosGrupoG,
                classificadosGrupoH);
        
        ArrayList<String> classificadosQuartas = quartasDeFinal(
                classficadosOitavas.get(0),
                classficadosOitavas.get(1),
                classficadosOitavas.get(2),
                classficadosOitavas.get(3),
                classficadosOitavas.get(4),
                classficadosOitavas.get(5),
                classficadosOitavas.get(6),
                classficadosOitavas.get(7));
        
        ArrayList<String> semiFinais = semiFinal(
                classificadosQuartas.get(0),
                classificadosQuartas.get(1),
                classificadosQuartas.get(2),
                classificadosQuartas.get(3));
        
        String campeao = Final(semiFinais.get(0), semiFinais.get(1));
        
        JOptionPane.showMessageDialog(null, "Campeão:. "+ campeao);
        
        return campeao;
        
    }
    
    

}
