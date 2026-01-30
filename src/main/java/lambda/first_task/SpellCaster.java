package lambda.first_task;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.spellAction(spell);
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String innervate = "иннервейт";

        spellCaster.cast(innervate, spell -> "Кароче " + spell + " создает бесшумный барьер");
    }
}
