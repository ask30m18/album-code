<?php
class Photo_model extends CI_Model {

    function get_album_photo($photo_id){
        return $this->db->query("SELECT a.* FROM photo AS a, user AS u WHERE a.album_id='".$photo_id."' ")->result_array();
    }

    function get_all_photos($album_id){
        return $this->db->query("SELECT a.* FROM photo AS a WHERE a.album_id='".$album_id."' ")->result_array();
    }

    function get_photo_byId($photo_id){
        return $this->db->query("SELECT FROM photo AS a WHERE a.photo_id='".$photo_id."'")->result_array();
    }

    function get_photo_byKeyword($key){
        return $this->db->query("SELECT p.photo_url FROM photograph AS p, keyword AS k WHERE k.key='".$key."' AND k.keyword_photo_id=p.photo_id  ")->result_array();
    }

    function get_photo_byUrl($url){
        return $this->db->query("SELECT FROM photo AS a WHERE a.photo_url='".$url."'")->result_array();
    }

}
?>