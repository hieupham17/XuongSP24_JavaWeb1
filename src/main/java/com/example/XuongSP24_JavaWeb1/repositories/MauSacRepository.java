package com.example.XuongSP24_JavaWeb1.repositories;

import com.example.XuongSP24_JavaWeb1.entities.MauSac;

import java.util.ArrayList;
import java.util.List;

/*
    @author: admin Date: 012/12/03/2024 Time: 13:08
*/
public class MauSacRepository {
    private List<MauSac> list;

    public MauSacRepository() {
        this.list = new ArrayList<>();
        this.list.add(new MauSac(1, "fff", "white", 1));
        this.list.add(new MauSac(2, "000", "black", 0));
        this.list.add(new MauSac(4, "070707", "pink", 1));
    }

    public List<MauSac> getList() {
        return list;
    }

    public void setList(List<MauSac> list) {
        this.list = list;
    }

    //  add
    public void insert(MauSac mauSac) {
        this.list.add(mauSac);
    }

    // update
    public void update(MauSac mauSac) {
        for (int i = 0; i < this.list.size(); i++) {
            MauSac item = this.list.get(i);
            if (item.getId() == mauSac.getId()) {
                this.list.set(i, mauSac);
                return;
            }
        }
    }

    //delete
    public void delete(MauSac mauSac) {
        for (int i = 0; i < this.list.size(); i++) {
            MauSac item = this.list.get(i);
            if (item.getId() == mauSac.getId()) {
                this.list.remove(i);
                return;
            }
        }
    }

    public MauSac getOne(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            MauSac mauSac = this.list.get(i);
            if (mauSac.getId() == id) {
                return mauSac;

            }
        }
        return null;
    }
}
