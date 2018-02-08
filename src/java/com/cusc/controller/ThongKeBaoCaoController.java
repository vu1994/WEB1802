/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.DanhMucThietBiDataProvider;
import com.cusc.dataprovider.QuanLyThietBiDataProvider;
import com.cusc.dataprovider.ThongKeBaoCaoDataprovider;
import com.cusc.dataprovider.TinhTrangDataprovider;
import com.cusc.model.DanhMucTinhTrangModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author npvu
 */
@ManagedBean(name = "ThongKeBaoCaoController")
@ViewScoped
public class ThongKeBaoCaoController implements Serializable {

    private int selectedTinhTrang;
    private String filterName;
    private List<Map> listNhomThietBi;
    private List<Map> listThietBiModel;
    private Integer moiNhap;
    private Integer dangSuDung;
    private Integer daSuDung;
    private Integer hong;
    private Integer capMoi;
    private Integer capBoSung;
    private Integer thuHoi;

    ThongKeBaoCaoDataprovider tkbcDp = new ThongKeBaoCaoDataprovider();

    public ThongKeBaoCaoController() {
        try {
            this.actionGetListThongKeTonKho();
            System.out.println(">>>" + tkbcDp.thongKeTrangThaiTB(2));
            moiNhap = tkbcDp.thongKeTrangThaiTB(1);
            daSuDung = tkbcDp.thongKeTrangThaiTB(2);
            dangSuDung = tkbcDp.thongKeTrangThaiTB(3);
            hong = tkbcDp.thongKeTrangThaiTB(4);
            capMoi = tkbcDp.thongKeTrangThaiCP("Cấp mới");
            capBoSung = tkbcDp.thongKeTrangThaiCP("Cấp bổ sung");
            thuHoi = tkbcDp.thongKeTrangThaiCP("Đã thu hồi");
                    
            System.out.println(">>>"+moiNhap +">>>"+daSuDung +">>>"+ dangSuDung +">>>"+ hong +">>>"+ capMoi +">>>"+capBoSung +">>>"+ thuHoi);
         } catch (Exception e) {
         }
    }

    public void actionGetListThongKeTonKho() {
        // Lấy danh sách nhóm thiết bị
        DanhMucThietBiDataProvider dmTBProvider = new DanhMucThietBiDataProvider();
        QuanLyThietBiDataProvider tbProvider = new QuanLyThietBiDataProvider();
        listNhomThietBi = dmTBProvider.getListDmThietBi();
        int size = 0;
        if (listNhomThietBi.size() > 0) {
            size = listNhomThietBi.size();
            Map mapTong = new HashMap();
            mapTong.put("danhmuc_thietbi_ten", "Tổng số");
            mapTong.put("tongso", 0);
            mapTong.put("ttChuaCapPhat", 0);
            mapTong.put("ttDaCapPhat", 0);

            mapTong.put("ttMoi", 0);
            mapTong.put("ttDangSuDung", 0);
            mapTong.put("ttDaSuDung", 0);
            mapTong.put("ttBiHong", 0);

            mapTong.put("ttCapMoi", 0);
            mapTong.put("ttCapBoSung", 0);
            mapTong.put("ttThuHoi", 0);
            listNhomThietBi.add(size, mapTong);
        }
        // Lấy danh sách thiết bị theo từng nhóm
        for (int i = 0; i <= size - 1; i++) {
            Map mapNhomThietBi = listNhomThietBi.get(i);
            List<Map> listThietBi = tbProvider.getListThietBiByNhom(Long.parseLong(mapNhomThietBi.get("danhmuc_thietbi_id").toString()));
            // Khai báo số liệu thống kê
            int tongso = 0;

            // -- tinh trang
            int ttMoi = 0;
            int ttDaSuDung = 0;
            int ttDangSuDung = 0;
            int ttBiHong = 0;

            // -- trang thai cap phat
            int ttCapMoi = 0;
            int ttCapBoSung = 0;
            int ttThuHoi = 0;
            int ttChuaCapPhat = 0;

            // Ghi số liệu thống kê
            tongso = listThietBi.size();

            for (Map mapThietBi : listThietBi) {
                // Đếm tình trạng
                int tinhTrang = Integer.parseInt(mapThietBi.get("tinhtrang_id").toString());
                switch (tinhTrang) {
                    case 1:
                        ttMoi++;
                        break;
                    case 2:
                        ttDangSuDung++;
                        break;
                    case 3:
                        ttDaSuDung++;
                        break;
                    case 4:
                        ttBiHong++;
                        break;
                }

                // Đếm trạng thái cấp phát
                String trangThaiCP = "";
                if (mapThietBi.get("thietbi_trangthai_capphat") != null && mapThietBi.get("thietbi_trangthai_capphat") != "") {
                    trangThaiCP = mapThietBi.get("thietbi_trangthai_capphat").toString();
                }
                switch (trangThaiCP) {
                    case "Cấp mới":
                        ttCapMoi++;
                        break;
                    case "Cấp bổ sung":
                        ttCapBoSung++;
                        break;
                    case "Đã thu hồi":
                        ttThuHoi++;
                        break;
                    case "":
                        ttChuaCapPhat++;
                        break;
                }
            }
            mapNhomThietBi.put("tongso", tongso);
            listNhomThietBi.get(size).put("tongso", Integer.parseInt(listNhomThietBi.get(size).get("tongso").toString()) + tongso);
            mapNhomThietBi.put("ttChuaCapPhat", ttChuaCapPhat);
            listNhomThietBi.get(size).put("ttChuaCapPhat", Integer.parseInt(listNhomThietBi.get(size).get("ttChuaCapPhat").toString()) + ttChuaCapPhat);
            mapNhomThietBi.put("ttDaCapPhat", tongso - ttChuaCapPhat);
            listNhomThietBi.get(size).put("ttDaCapPhat", Integer.parseInt(listNhomThietBi.get(size).get("ttDaCapPhat").toString()) + (tongso - ttChuaCapPhat));

            mapNhomThietBi.put("ttMoi", ttMoi);
            listNhomThietBi.get(size).put("ttMoi", Integer.parseInt(listNhomThietBi.get(size).get("ttMoi").toString()) + ttMoi);
            mapNhomThietBi.put("ttDangSuDung", ttDangSuDung);
            listNhomThietBi.get(size).put("ttDangSuDung", Integer.parseInt(listNhomThietBi.get(size).get("ttDangSuDung").toString()) + ttDangSuDung);
            mapNhomThietBi.put("ttDaSuDung", ttDaSuDung);
            listNhomThietBi.get(size).put("ttDaSuDung", Integer.parseInt(listNhomThietBi.get(size).get("ttDaSuDung").toString()) + ttDaSuDung);
            mapNhomThietBi.put("ttBiHong", ttBiHong);
            listNhomThietBi.get(size).put("ttBiHong", Integer.parseInt(listNhomThietBi.get(size).get("ttBiHong").toString()) + ttBiHong);

            mapNhomThietBi.put("ttCapMoi", ttCapMoi);
            listNhomThietBi.get(size).put("ttCapMoi", Integer.parseInt(listNhomThietBi.get(size).get("ttCapMoi").toString()) + ttCapMoi);
            mapNhomThietBi.put("ttCapBoSung", ttCapBoSung);
            listNhomThietBi.get(size).put("ttCapBoSung", Integer.parseInt(listNhomThietBi.get(size).get("ttCapBoSung").toString()) + ttCapBoSung);
            mapNhomThietBi.put("ttThuHoi", ttThuHoi);
            listNhomThietBi.get(size).put("ttThuHoi", Integer.parseInt(listNhomThietBi.get(size).get("ttThuHoi").toString()) + ttThuHoi);

        }
    }

    public List<Map> actionFilterListThongKeTonKho() {
        listThietBiModel = tkbcDp.getDsThongKeTonKho(filterName, selectedTinhTrang);
        return listThietBiModel;
    }

    public List<DanhMucTinhTrangModel> actionGetListDMTinhTrang() {
        TinhTrangDataprovider dmttDp = new TinhTrangDataprovider();
        return dmttDp.getDmTinhTrang();
    }

    public int getSelectedTinhTrang() {
        return selectedTinhTrang;
    }

    public void setSelectedTinhTrang(int selectedTinhTrang) {
        this.selectedTinhTrang = selectedTinhTrang;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public List<Map> getListThietBiModel() {
        return listThietBiModel;
    }

    public void setListThietBiModel(List<Map> listThietBiModel) {
        this.listThietBiModel = listThietBiModel;
    }

    public List<Map> getListNhomThietBi() {
        return listNhomThietBi;
    }

    public void setListNhomThietBi(List<Map> listNhomThietBi) {
        this.listNhomThietBi = listNhomThietBi;
    }

    public Integer getMoiNhap() {
        return moiNhap;
    }

    public void setMoiNhap(Integer moiNhap) {
        this.moiNhap = moiNhap;
    }

    public Integer getDangSuDung() {
        return dangSuDung;
    }

    public void setDangSuDung(Integer dangSuDung) {
        this.dangSuDung = dangSuDung;
    }

    public Integer getDaSuDung() {
        return daSuDung;
    }

    public void setDaSuDung(Integer daSuDund) {
        this.daSuDung = daSuDung;
    }

    public Integer getHong() {
        return hong;
    }

    public void setHong(Integer hong) {
        this.hong = hong;
    }

    public Integer getCapMoi() {
        return capMoi;
    }

    public void setCapMoi(Integer capMoi) {
        this.capMoi = capMoi;
    }

    public Integer getCapBoSung() {
        return capBoSung;
    }

    public void setCapBoSung(Integer capBoSung) {
        this.capBoSung = capBoSung;
    }

    public Integer getThuHoi() {
        return thuHoi;
    }

    public void setThuHoi(Integer thuHoi) {
        this.thuHoi = thuHoi;
    }
}
