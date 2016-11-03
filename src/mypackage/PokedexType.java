
package mypackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for PokedexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PokedexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pokemon" type="{}PokemonType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name="Pokedex"
)
@XmlType(name = "PokedexType", propOrder = {
    "pokemon"
})
public class PokedexType {

    @XmlElement(name = "Pokemon")
    protected List<PokemonType> pokemon;

    /**
     * Gets the value of the pokemon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pokemon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPokemon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PokemonType }
     * 
     * 
     */
    public List<PokemonType> getPokemon() {
        if (pokemon == null) {
            pokemon = new ArrayList<PokemonType>();
        }
        return this.pokemon;
    }

}
