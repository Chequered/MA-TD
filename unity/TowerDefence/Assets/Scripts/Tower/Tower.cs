using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Tower : MonoBehaviour {

    private Gun gun;
    private List<GameObject> enemiesInRange = new List<GameObject>();

    private void Start()
    {
        gun = transform.FindChild("Gun").GetComponent<Gun>();
    }

    private void OnTriggerEnter(Collider coll)
    {
        if(coll.transform.tag == "Enemy")
        {
            enemiesInRange.Add(coll.gameObject);
            gun.SetTarget(coll.gameObject);
        }
    }

}
