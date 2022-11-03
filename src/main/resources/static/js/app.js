const main = {
    init: function () {
        const _this = this;

        // 댓글 저장
        $('#btn-comment-save').on('click', function () {
            alert("11");
            _this.commentSave();
        });

        $('#btn-Member-save').on('click', function () {
            alert("11");
            _this.memberSave();
        });
    },

    /** 댓글 저장 */
    memberSave: function () {
        const data = {
            postsId: $('#postsId').val(),
            comment: $('#comment').val()
        };
            $.ajax({
                type: 'POST',
                url: '/api/posts/' + data.postsId + '/comments',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('댓글이 등록되었습니다.');
                window.location.reload();

            }).fail(function (error) {
                alert('댓글 입력 실패');
            });
        }

};
main.init();