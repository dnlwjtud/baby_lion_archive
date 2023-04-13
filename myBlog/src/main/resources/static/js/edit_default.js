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

    // @ToString X

    // SyntaxError: Unexpected token '<', "<!DOCTYPE "... is not valid JSON

    let formData = new FormData();
    formData.append('title', postTitle);
    formData.append('body', htmlData);

    fetch("http://localhost:8083/posts/write", {
        method: "POST",
        body : formData
    })
    .then(
        (resp) => {
            console.log('resp', resp);
            if (resp.status == 200) {
                alert("작성 완료!");
                location.replace("/")
            }
        }
    )
    .catch(
        (err) => {
            console.log(err);
        }
    )


}

