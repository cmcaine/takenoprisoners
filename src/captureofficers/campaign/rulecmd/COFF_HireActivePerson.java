package captureofficers.campaign.rulecmd;

import captureofficers.ui.PrisonersDialogDelegate;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.BaseCommandPlugin;
import com.fs.starfarer.api.util.Misc;

import java.util.List;
import java.util.Map;

public class COFF_HireActivePerson extends BaseCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        PersonAPI person = Global.getSector().getPlayerFleet().getActivePerson();
        person.setFaction(Global.getSector().getPlayerFaction().getId());
        Global.getSector().getPlayerFleet().getFleetData().addOfficer(person);

        PrisonersDialogDelegate.getInst().removePerson(person, null);
        return true;
    }
}