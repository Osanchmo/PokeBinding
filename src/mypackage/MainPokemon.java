package mypackage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class MainPokemon {
    public static void main(String[] args) {
        //utilitzarem l'Scanner per a afegir un pokemon personalitzat
        Scanner in = new Scanner(System.in);
        //iniciem el fitxer
        File f1 = new File("pokemons.xml");

        //per a obtindre l'atribut de Nombre tenim que separar
        //NombreType y PokemonType
        NombreType nt = new NombreType();
        PokemonType pk = new PokemonType();

        //Valors per al NombreType
        System.out.println("Crea el teu propi pokemon!");
        System.out.print("Escriu el nom: ");
        nt.setValue(in.nextLine());
        System.out.print("tipus: ");
        nt.setClasse(in.nextLine());

        //Afegim el nom+clase a PokemonType per a unificar
        pk.setNombre(nt);

        //Valors per a PokemonType
        System.out.print("PVs: ");
        pk.setPV(in.nextLine());
        System.out.print("Etapa/Fase: ");
        pk.setEtapa(in.nextLine());
        System.out.print("Atac1: ");
        pk.setAtaque1(in.nextLine());
        System.out.print("Atac2: ");
        pk.setAtaque2(in.nextLine());

        try {
            //SAX i DOM factory, en este caso context
            JAXBContext context = JAXBContext.newInstance(PokedexType.class);

            //Para "desunir" el fichero xml
            //desunir significa separar la lógica xml y pasarla a
            //Listado de clases JAVA
            Unmarshaller um = context.createUnmarshaller();
            //Creemo un PokedexType per que es tracta del root element
            PokedexType pt = (PokedexType) um.unmarshal(f1);

            //Afegim a PokedexType(Unmarshal) el pokemon creat
            pt.getPokemon().add(pk);
            //cridem al metode guardar
            guardar(pt);

            //Mostrem la llista de pokemons per comprobar si esta el nou pokemon
            for(int i = 0; i< pt.getPokemon().size(); i++){
                System.out.println("El Pokemon: " +
                        pt.getPokemon().get(i).getNombre().value + " \n de tipo: " +
                        pt.getPokemon().get(i).getNombre().classe + "\n Con PVs: " +
                        pt.getPokemon().get(i).getPV() + "\n En su etapa: " +
                        pt.getPokemon().get(i).getEtapa() + "\n Con ataques: " +
                        pt.getPokemon().get(i).getAtaque1() + ", " +
                        pt.getPokemon().get(i).getAtaque2() + "\n" );
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * A partir d'un objecte PokedexType(root element) generem un fitxer XML
     */
    private static void guardar(PokedexType pt) {
        File flg = new File("PokemonNew.xml");
        try {

            JAXBContext context = JAXBContext.newInstance(PokedexType.class);
            //con el Marshaller convertimos el listado de clases java en un XML
            Marshaller n = context.createMarshaller();
            n.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            n.marshal(pt,flg);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
