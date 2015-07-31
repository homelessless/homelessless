package homelessless.govhack.org.homelessless;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import homelessless.govhack.org.homelessless.models.Organisation;

public class OrganisationListFragment extends ListFragment {

    private Adapter adapter;
    private int catId;

    public OrganisationListFragment() {
    }

    // TODO: Replace with Bundle passing to fragment...
    public OrganisationListFragment(int catId) {
        this.catId = catId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(android.R.layout.list_content, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        DatabaseHelper helper = new DatabaseHelper( getActivity() );
        adapter = new Adapter( getActivity(), helper.getOrganisationList( catId ) );
        setListAdapter( adapter );
    }

    class Adapter extends ArrayAdapter<Organisation> {
        public Adapter(Context context, List<Organisation> organisations) {
            super(context, android.R.layout.two_line_list_item, organisations);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if ( convertView == null ) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.org_list_item, parent, false);
            }

            TextView name = (TextView)convertView.findViewById(R.id.name);
            TextView desc = (TextView)convertView.findViewById(R.id.desc);

            name.setText(getItem(position).getName());
            desc.setText(getItem(position).getDescription());

            return convertView;
        }
    }
}
