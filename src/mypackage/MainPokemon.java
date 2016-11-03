package mypackage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainPokemon {
    public static void main(String[] args) {

        File f1 = new File("pokemons.xml");

        NombreType nt = new NombreType();
            nt.setValue("Pikachu");
            nt.setClasse("Electrico");

        PokemonType pk = new PokemonType();
            pk.setNombre(nt);
            pk.setPV("140");
            pk.setEtapa("Etapa fuelte");
            pk.setAtaque1("Impactrueno");
            pk.setAtaque2("Trueno");

        try {
            //SAX i DOM factoria, en este caso context
            JAXBContext context = JAXBContext.newInstance(PokedexType.class);

            //Para "desunir" el fichero xml
            //desunir significaseparar la lógica xml y pasarla a
            //Listado de clases JAVA
            Unmarshaller um = context.createUnmarshaller();
            PokedexType pt = (PokedexType) um.unmarshal(f1);
            pt.getPokemon().add(pk);
            guardar(pt);

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
    private static void guardar(PokedexType bl) {
        File flg = new File("PokemonNew.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(PokedexType.class);

            Marshaller n = context.createMarshaller();
            n.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            n.marshal(bl,flg);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
