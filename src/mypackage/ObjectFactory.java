
package mypackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Pokedex_QNAME = new QName("", "Pokedex");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PokedexType }
     * 
     */
    public PokedexType createPokedexType() {
        return new PokedexType();
    }

    /**
     * Create an instance of {@link PokemonType }
     * 
     */
    public PokemonType createPokemonType() {
        return new PokemonType();
    }

    /**
     * Create an instance of {@link NombreType }
     * 
     */
    public NombreType createNombreType() {
        return new NombreType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PokedexType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Pokedex")
    public JAXBElement<PokedexType> createPokedex(PokedexType value) {
        return new JAXBElement<PokedexType>(_Pokedex_QNAME, PokedexType.class, null, value);
    }

}
