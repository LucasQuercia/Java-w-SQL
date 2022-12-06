import java.sql.*;
class Main 

{
  public static void main(String[] args) 
  {
    System.out.println("Hello world!");



    //Objeto conexao
    Connection conexao = null;

    //Objeto statement (receber os comandos)
    Statement comando = null;

    try 
      {
        //Informar a classe do Driver
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:dc_universe.db");

        //Instanciar o statement

        comando = conexao.createStatement();

        //
        String sql = "SELECT pessoa_id, nome, nome_civil, tipo FROM pessoas";
        ResultSet consulta = comando.executeQuery(sql);

        while(consulta.next() == true)
          {
            String nome = consulta.getString("nome");
            System.out.println(nome);

            String tipo = consulta.getString("tipo");
            System.out.println(tipo);
            
          }
        
      }
    catch(Exception e)
      {
        System.out.println("Deu ruim");
        System.out.println(e);
      }
  }
}