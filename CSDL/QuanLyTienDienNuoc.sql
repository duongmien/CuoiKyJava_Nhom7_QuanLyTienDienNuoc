create database QuanLyTienDienNuoc

go
use QuanLyTienDienNuoc
go
create table NhanVien (
	MaNV int identity primary key,
	TenNV nvarchar(50),
	username nvarchar(50),
	GioiTinh nvarchar(10),
	ngaysinh date,
	sdt nvarchar(12),
	diachi nvarchar(100),
	chucvu nvarchar(50),
	MatKhau nvarchar(50)
)
go
create table tblAdmin (
	MaAdmin int identity primary key,
	TenAdmin nvarchar(50),
	username nvarchar(50),
	GioiTinh nvarchar(10),
	ngaysinh date,
	sdt nvarchar(12),
	diachi nvarchar(100),
	chucvu nvarchar(50),
	MatKhau nvarchar(50)
)
go
create table GiaDien(
	idGD int identity primary key,
	MucTieuThu nvarchar(20),
	giaDien real
)
go
create table GiaNuoc(
	idGN int identity primary key,
	MucTieuThu nvarchar(20),
	giaNuoc real
)
go
create table KhachHang(
	MaKH int identity primary key,
	TenKH nvarchar(50),
	ngaysinh date,
	GioiTinh nvarchar(10),
	SDT nvarchar(12),
	DiaChi nvarchar(100)
)
go
create table tblSotieuthu
(
	IdTT int identity primary key,
	MaKH  int foreign key references KhachHang(MaKH),
	chisocuDien float,
	chisomoiDien float,
	chisocuNuoc float,
	chisomoiNuoc float,
	ngayNhap date,
)
go
create table tblHoaDon
(
	IdHD int identity primary key,
	MaKH  int foreign key references KhachHang(MaKH),
	TenKH nvarchar(50),
	TongTienDien real,
	TongTienNuoc real,
	ngayTaoHD date,
)
--Insert 1 tblAdmin

Insert into tblAdmin values(N'Miên','mien123',N'nữ','2001-1-1','0911929193',N'Quảng Nam',N'Giám đốc','123456')


--Insert 5 NhanVien
Insert into NhanVien values(N'Sơn','son123','nam','2001-1-1','0911929192',N'Quảng Bình',N'Nhân viên','123456')
Insert into NhanVien values(N'Miên','mien123',N'nữ','2001-1-1','0911929193',N'Quảng Nam',N'Nhân viên','123456')
Insert into NhanVien values(N'Hạ','ha123',N'nữ','2001-1-1','0911929194',N'Quảng Nam',N'Nhân viên','123456')
Insert into NhanVien values(N'Linh','tlinh123',N'nữ','2001-1-1','0911929195',N'Nghệ An',N'Nhân viên','123456')
Insert into NhanVien values(N'Linh','hlin123',N'nữ','2001-1-1','0911929196',N'Quảng Ngãi',N'Nhân viên','123456')

Insert into GiaDien values('0-50',1549)
Insert into GiaDien values('51-100',1600)
Insert into GiaDien values('101-200',1858)
Insert into GiaDien values('201-300',2340)
Insert into GiaDien values('301-400',2615)
Insert into GiaDien values(N'400 trở lên',2701)

Insert into GiaNuoc values('0-4m3',6300)
Insert into GiaNuoc values('4m3-6m3',12100)
Insert into GiaNuoc values(N'Trên 6m3',13600)

Insert into KhachHang values(N'Hồng Sơn','2001-1-1','nam','0911929192',N'Quảng Bình')
Insert into KhachHang values(N'An Miên','2001-1-1',N'nữ','0911929193',N'Quảng Nam')
Insert into KhachHang values(N'Khánh Hạ','2001-1-1',N'nữ','0911929194',N'Quảng Nam')
Insert into KhachHang values(N'Thùy Linh','2001-1-1',N'nữ','0911929195',N'Nghệ An')
Insert into KhachHang values(N'Hoàng Linh','2001-1-1',N'nữ','0911929196',N'Quảng Ngãi')

Insert into tblSotieuthu values(1,125,180,136,148,'2021-5-26')
Insert into tblSotieuthu values(2,115,129,166,200,'2021-5-26')
Insert into tblSotieuthu values(3,124,163,36,78,'2021-5-26')
Insert into tblSotieuthu values(4,156,190,116,138,'2021-5-26')
Insert into tblSotieuthu values(5,25,80,136,168,'2021-5-26')

Insert into tblHoaDon values(1,N'Hồng Sơn',80000,68000,'2021-5-26')
Insert into tblHoaDon values(2,N'An Miên',68000,42000,'2021-5-26')
Insert into tblHoaDon values(3,N'Khánh Hạ',103000,100000,'2021-5-26')
Insert into tblHoaDon values(4,N'Thùy Linh',54000,25000,'2021-5-26')
Insert into tblHoaDon values(5,N'Hoàng Linh',96000,20000,'2021-5-26')
