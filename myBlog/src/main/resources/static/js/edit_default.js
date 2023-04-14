const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    height: '550px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
});

// 버튼을 클릭했을 때, 이벤트 라는것을 감지하여 데이터를 추출하고
// Java로 보내는 것

function writePost(e) {

    // 제목
    const postTitle = document.querySelector("#post-title")
        .value;

    console.log('postTitle' , postTitle);

    // 포스트의 내용
    const htmlData = editor.getHTML();
    const markdownData = editor.getMarkdown();

    console.log('HTML', htmlData);
    console.log('MarkDown', markdownData);

    // form
    const formData = new FormData();
    formData.append('title', postTitle );
    formData.append('body', htmlData);


    fetch("http://localhost:8083/posts/write", {
        method: "POST",
        body : formData
    })
    .then(
        (resp) => resp.json()
    )
    .then(
        (data) => {

            console.log(data); // {postId:10}

            alert("포스트 작성이 완료되었습니다.");
            // location.replace("/posts/" + data.postId);
            location.replace(`/posts/${data.postId}`);

        }
    )
    .catch(
        (err) => {
            console.log(err);
        }
    )


}

