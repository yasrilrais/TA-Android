<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class ServerApi extends CI_Controller {

      //Fungsi Staff
      function loginStaff()
      {
        $email = $this->input->post('email');
        $password = $this->input->post('password');
        
        $this->db->where('user_email',$email);
        $this->db->where('user_password',md5($password));

        $q = $this->db->get('tb_user');

        if($q -> num_rows() > 0){
            $data['message'] = 'Login Success';
            $data['status'] = 200;
            $data['user'] = $q -> row();
        } else {
            $data['message'] = 'Email atau Password Salah';
            $data['status'] = 404;
        }
        echo json_encode($data);
      }

    //Fungsi Register
      function registerStaff()
      {
          $nama = $this->input->post('nama');
          $nim = $this->input->post('nim');
          $email = $this->input->post('email');
          $password = $this->input->post('password');

          $this->db->where('user_email',$email);
          $this->db->or_where('user_nim',$nim);

          $q = $this->db->get('tb_user');
          if($q -> num_rows() > 0){
              $data['message'] = 'Email atau NIM sudah terdaftar, silahkan Sign In';
              $data['status'] = 404;
          } 
          else{
              $simpan['user_nama'] = $nama;
              $simpan['user_nim'] = $nim;
              $simpan['user_email'] = $email;
              $simpan['user_password'] = md5($password);

              $q = $this->db->insert('tb_user', $simpan);
              if($q){
                  $data['message'] = 'success';
                  $data['status'] = 200;
              } else {
                  $data['message'] = 'error';
                  $data['status'] = 404;
              
              }
          }
          echo json_encode($data);
      }

    // fungsi untuk CREATE
    public function addStaff()
    {
          // deklarasi variable
          $name = $this->input->post('name');
          $keluhan = $this->input->post('keluhan');
          $fakultas = $this->input->post('fakultas');
          $penerima = $this->input->post('penerima'); 
          $tanggal = $this->input->post('tanggal');
          $tipe = $this->input->post('tipe');
          $tindakan = $this->input->post('tindakan');
          $status = $this->input->post('status');
          // isikan variabel dengan nama file
          $data['staff_name'] = $name;
          $data['staff_keluhan'] = $keluhan;
          $data['staff_fakultas'] = $fakultas;
          $data['staff_penerima'] = $penerima;
          $data['staff_tanggal'] = $tanggal;
          $data['staff_tipe'] = $tipe;
          $data['staff_tindakan'] = $tindakan;
          $data['staff_status'] = $status;
          $q = $this->db->insert('tb_data', $data);
          // check insert berhasil apa nggak
          if ($q) {
            $response['pesan'] = 'insert berhasil';
            $response['status'] = 200;
          } else {
            $response['pesan'] = 'insert error';
            $response['status'] = 404;
          }
          echo json_encode($response);
    }
      // fungsi untuk READ
    public function getDataStaff()
    {
          $q = $this->db->get('tb_data');
          if ($q -> num_rows() > 0) {
            $response['pesan'] = 'data ada';
            $response['status'] = 200;
            // 1 row
            $response['staff'] = $q->row();
            $response['staff'] = $q->result();
          } else {
            $response['pesan'] = 'data tidak ada';
            $response['status'] = 404;
          }
          echo json_encode($response);
    }
      // fungsi untuk DELETE
    public function deleteStaff()
    {
          $id = $this->input->post('id');
          $this->db->where('staff_id', $id);
          $status = $this->db->delete('tb_data');
          if ($status == true) {
            $response['pesan'] = 'hapus berhasil';
            $response['status'] = 200;
          } else {
            $response['pesan'] = 'hapus error';
            $response['status'] = 404;
          }
          echo json_encode($response);
    }
      // fungsi untuk UPDATE
    public function updateStaff()
    {
          // deklarasi variable
          $id = $this->input->post('id');
          $name = $this->input->post('name');
          $keluhan = $this->input->post('keluhan');
          $fakultas = $this->input->post('fakultas');
          $penerima = $this->input->post('penerima');
          $tanggal = $this->input->post('tanggal');
          $tipe = $this->input->post('tipe');
          $tindakan = $this->input->post('tindakan');
          $status = $this->input->post('status');
          $this->db->where('staff_id', $id);
          // isikan variabel dengan nama file
          $data['staff_name'] = $name;
          $data['staff_keluhan'] = $keluhan;
          $data['staff_fakultas'] = $fakultas;
          $data['staff_penerima'] = $penerima;
          $data['staff_tanggal'] = $tanggal;
          $data['staff_tipe'] = $tipe;
          $data['staff_tindakan'] = $tindakan;
          $data['staff_status'] = $status;
          $q = $this->db->update('tb_data', $data);
          // check insert berhasil apa nggak
          if ($q) {
            $response['pesan'] = 'update berhasil';
            $response['status'] = 200;
          } else {
            $response['pesan'] = 'update error';
            $response['status'] = 404;
          }
          echo json_encode($response);
    }
}