function removePost(postId) {

   if ( confirm('정말 삭제하시겠습니까?') ) {

       fetch(`http://localhost:8083/adms/posts/delete/${postId}`)
           .then(
               (resp) => {
                   location.reload();
               }
           )
           .catch(
               (err) => console.log(err)
           )

   }

}