package homelessless.govhack.org.homelessless;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OrganisationListFragment extends ListFragment {

    // TODO: Need to populate array list with organisations
    // TODO: OnListItemClick, launch detail activity and pass selected organisation

    public OrganisationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(android.R.layout.list_content, container, false);
    }


}
