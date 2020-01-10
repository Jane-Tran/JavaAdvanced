
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="./js/main.js" ></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>

<script>
    function EditHoatDong(maHD,tenHD, moTaHD, ngayGioBD, ngayGioKT, sLToiThieuYC,sLToiDaYC,thoiHanDK,trangThai,maTV) {
        document.getElementById("editMaHD").value = maHD;
        document.getElementById("editTenHD").value = tenHD;
        document.getElementById("editMoTaHD").value = moTaHD;
        document.getElementById("editNgayGioBD").value = ngayGioBD ;
        document.getElementById("editNgayGioKT").value = ngayGioKT;
        document.getElementById("editSLToiThieuYC").value = sLToiThieuYC;
        document.getElementById("editSLToiDaYC").value = sLToiDaYC;
        document.getElementById("editThoiHanDK").valueAsDate = new Date(thoiHanDK);
        document.getElementById("editTrangThai").value = trangThai;
        document.getElementById("editMaTV").value = maTV;
    }
    function DeleteHoatDong(ma){
        document.getElementById("DeleteMaHD").value = ma;
    }
</script>